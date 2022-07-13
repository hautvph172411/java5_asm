package com.lab.crud.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab.crud.entities.Lamp;
import com.lab.crud.entities.LampOrigin;
import com.lab.crud.entities.LampBrand;
import com.lab.crud.repositories.ILampRepository;
import com.lab.crud.services.LampService;






@Controller
public class LayoutController {
	@Autowired
	private LampService  service;
	
	@Autowired
	private ILampRepository responsetory;
	
	@GetMapping("/home")
	public String layout (Model model) {
		
		model.addAttribute("view", "/WEB-INF/home1.jsp");
		return "layout";
	}

	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("view", "/WEB-INF/about1.jsp");
		return "layout";
	}
	
	@GetMapping("/contact")
	public String contact(Model model) {
	
		model.addAttribute("view", "/WEB-INF/contact1.jsp");
		return "layout";
	}
	
	
	
	
	 @GetMapping("/home/find")
	    public String showlAMP(Model model,@RequestParam(name = "name",defaultValue = "") String name) {
		 
	    	List<Lamp> listLamp = service.getName(name);
	    	model.addAttribute("listLamp",listLamp);
	    	model.addAttribute("view", "/WEB-INF/shop.jsp");
	    	return "layout";
	    }
	
	
}
