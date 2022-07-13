package com.lab.crud.controllers;

import java.math.BigDecimal;
import java.util.Calendar;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab.crud.entities.Orders;
import com.lab.crud.entities.Users;
import com.lab.crud.entities.OrderDetail;
import com.lab.crud.repositories.IOrderRepository;
import com.lab.crud.repositories.UsersRepository;
import com.lab.crud.services.CartService;
import com.lab.crud.services.LampService;
import com.lab.crud.services.OrderDetailService;
import com.lab.crud.services.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	IOrderRepository orderDao;
	@Autowired
	UsersRepository userDao;
	@Autowired
	private OrderService OrderService;
	@Autowired
	private OrderDetailService detailService;
	@Autowired
	private CartService CartService;
	@Autowired
	private LampService lampService;

	@GetMapping("/index")
	public String index(ModelMap map) {
		List<OrderDetail> list = CartService.getAll();
		if(!list.isEmpty()) {
		map.addAttribute("list", list);

		double tongDouble = 0;
		for (OrderDetail o : list) {
			tongDouble += Double.parseDouble(String.valueOf(o.getQuantity()))
					* Double.parseDouble(String.valueOf(o.getPrice()));

		}
		map.addAttribute("tongsp", list.size());
		map.addAttribute("tongth", BigDecimal.valueOf(tongDouble));
		map.addAttribute("tamtinh", BigDecimal.valueOf(tongDouble));
		map.addAttribute("view", "/WEB-INF/order/index.jsp");
	}else {
		map.addAttribute("view", "/WEB-INF/cart/index.jsp");
		map.addAttribute("messageCart", "Giỏ Hàng của bạn trống !!!");
	}
		return "layout";
	}

	@PostMapping("/add")
	public String add(ModelMap map, Users user) throws Exception {
		
		
		List<OrderDetail> list = CartService.getAll();
		
			
		
		Orders o = new Orders();
		o.setCreatedDate(new Date(Calendar.getInstance().getTime().getTime()));
		// check user đã tồn tại chưa, nếu chưa thêm mới, nếu có thì update
		Users kk = null;
		if(checkEmail(user.getGmail())) {
			user.setPass("123");
			user.setRole(false);
			kk = userDao.save(user);
		}else {
			// da ton tai
			user = userDao.findByEmail(user.getGmail());
			kk = userDao.save(user);
		}
		
		o.setUser(kk);

		orderDao.save(o);
		
		double tongDouble = 0;
		for (OrderDetail oo : list) {
			tongDouble += Double.parseDouble(String.valueOf(oo.getQuantity()))
					* Double.parseDouble(String.valueOf(oo.getPrice()));
			oo.setOrder(o);//
			oo.getLamp().setQuantity(oo.getLamp().getQuantity()-oo.getQuantity());
			lampService.saveLamp(oo.getLamp());
			detailService.add(oo);
			
			//khi  mua hàng xong thì xóa giỏ hàng
 			detailService.delete(oo);
		}
		o.setTotal_money(String.valueOf(tongDouble));
		orderDao.save(o);
		
		map.addAttribute("mdh", o.getId());
		map.addAttribute("view", "/WEB-INF/order/done.jsp");
		
		return "layout";
	}

	@GetMapping("/detail")
	public String detail(ModelMap map, Long mdh) {
		Orders order = OrderService.findId(mdh);
		
		map.addAttribute("tongth", order.getTotal_money());
		map.addAttribute("tamtinh", order.getTotal_money());
		map.addAttribute("order", order);
		map.addAttribute("view", "/WEB-INF/order/detail.jsp");
		return "layout";
	}

	
	public boolean checkEmail(String email) {
		boolean check = true;
		for (Users s : userDao.findAll()) {
			if (s.getGmail().equals(email)) {
				check = false;
			}
		}
		return check;

	}

}
