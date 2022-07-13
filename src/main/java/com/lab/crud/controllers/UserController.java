package com.lab.crud.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab.crud.entities.Users;
import com.lab.crud.repositories.UsersRepository;
import com.lab.crud.services.CartService;
import com.lab.crud.services.OrderDetailService;
import com.lab.crud.services.OrderService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private OrderService ser;
	@Autowired
	private OrderDetailService detailService;
	@Autowired
	private CartService Cser;
	@Autowired
	private UsersRepository userdao;
	@Autowired
	private OrderDetailService Odser;
	@Autowired
	private HttpSession session;

	@GetMapping("/login")
	public String loginGet(Model model) {

		model.addAttribute("view", "/WEB-INF/user/loggin.jsp");
		return "layout";

	}

	@PostMapping("/login")
	public String login(Model model, Users user) {
		Users uDatabase = userdao.findByEmailnPassword(user.getGmail(), user.getPass());
		if (uDatabase != null) {
			session.setAttribute("user", uDatabase);
			session.setAttribute("role", uDatabase.getRole());
		
			return "layout";
		} else {
			model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
			model.addAttribute("view", "/WEB-INF/user/loggin.jsp");
			return "layout";
		}

	}

	@RequestMapping("/logout")
	public String logout(Model model) {
		session.setAttribute("user", null);
		session.setAttribute("role", null);
		return "redirect:/user/login";

	}

	@GetMapping("/register")
	public String registerGet(Model model) {
		model.addAttribute("view", "/WEB-INF/user/register.jsp");
		return "layout";

	}

	@PostMapping("/register")
	public String register(Model model, Users user) {
		if (checkEmail(user.getGmail())) {
			user.setRole(false);
			userdao.save(user);
	
			return "redirect:/user/login";
		} else {
			model.addAttribute("messageRegister", "Email đã có người sử dụng !");
			model.addAttribute("view", "/WEB-INF/user/register.jsp");
			return "layout";
		}
	}

	@GetMapping("/add")
	public String indexAdd(Model model) {
		model.addAttribute("view", "/WEB-INF/user/addUser.jsp");
		return "layout";

	}

	@PostMapping("/add")
	public String add(Model model, Users user) {
		
		if (checkEmail(user.getGmail())) {
			user.setRole(false);
			userdao.save(user);
			userdao.save(user);
			return "redirect:/user/listuser";
		}  else {
			model.addAttribute("messageAdd", "Email đã có người sử dụng !");
			model.addAttribute("view", "/WEB-INF/user/addUser.jsp");
			return "layout";
		}
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam("id") long id) {
		model.addAttribute("user", userdao.findById(id).get());
		model.addAttribute("view", "/WEB-INF/user/update.jsp");
		return "layout";
	}

	@PostMapping("/update")
	public String update(Model model, @RequestParam("idUserUpdate") long id, Users user) {
		user.setId_user(id);
		userdao.save(user);
		return "redirect:/user/listuser";
	}

	@GetMapping("/delete")
	public String deleteGet(Model model, @RequestParam("id") long id) {
		userdao.delete(userdao.findById(id).get());
		return "redirect:/user/listuser";
	}

	@GetMapping("/listuser")
	public String listUser(Model model) {
		List<Users> list = userdao.findAll();
		model.addAttribute("listUser", list);
		model.addAttribute("view", "/WEB-INF/user/listuser.jsp");
		return "layout";
	}

	public boolean checkEmail(String email) {
		boolean check = true;
		for (Users s : userdao.findAll()) {
			if (s.getGmail().equals(email)) {
				check = false;
			}
		}
		return check;

	}
}
