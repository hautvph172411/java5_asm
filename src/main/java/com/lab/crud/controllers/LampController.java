package com.lab.crud.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.lab.crud.entities.Lamp;
import com.lab.crud.entities.LampBrand;
import com.lab.crud.services.LampService;
import com.lab.crud.entities.LampOrigin;
import com.lab.crud.repositories.ILampRepository;



@Controller
@RequestMapping("/lamp")
public class LampController {
	
	@Autowired
	private LampService  service;
	@Autowired
	private ILampRepository lampdao;
	
	 
	
	@GetMapping("")
	public String index(Model model) {
		List<Lamp> list = lampdao.findAll();
		model.addAttribute("listLamp", list);
		model.addAttribute("view", "/WEB-INF/lamp/index.jsp");
		return "layout";	
	}
	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id",required = true) String id) {
		service.delete(id);
		return "redirect:/lamp";
	}
	@GetMapping("/deleteList")
	public String deleteList(String[] chk) {
		List<Integer> list=new ArrayList<>();
		for(String l:chk) {
			list.add(Integer.parseInt(l));
		}
		service.delete(list);
		
		return "redirect:/lamp";
	}
	@GetMapping("/add")
	public String formNew(Model model) {
		LampOrigin[] origin=LampOrigin.values();
		LampBrand[] brand=LampBrand.values();
		model.addAttribute("brand", brand);
		model.addAttribute("origin", origin);
		model.addAttribute("view", "/WEB-INF/lamp/add.jsp");
		return "layout";
	
	}
	@PostMapping("/new")
	public String add(Lamp lamp) {
		service.add(lamp);
		return "redirect:/lamp";
	}
	@GetMapping("/edit")
	public String detail(Model model,@RequestParam(name="id") String id) {
		LampOrigin[] origin=LampOrigin.values();
		LampBrand[] brand=LampBrand.values();
		Lamp l=service.findById(id);
		model.addAttribute("brand", brand);
		model.addAttribute("origin", origin);
		model.addAttribute("l", l);
		model.addAttribute("view", "/WEB-INF/lamp/update.jsp");
		return "layout";
	
	}
	
	@PostMapping("/update")
	public String update(Lamp lamp,@RequestParam(name="id",required = true) String id) {
		service.update(id,lamp);
		return "redirect:/lamp";
	}
	
	@GetMapping("/find")
	public String showlAMP(Model model,@RequestParam(name = "name",defaultValue = "") String name) {	 
    	List<Lamp> listLamp = service.getName(name);
    	model.addAttribute("listLamp",listLamp);
    	model.addAttribute("view", "/WEB-INF/lamp/index.jsp");
    	return "layout";
    }
}
