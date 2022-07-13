package com.lab.crud.controllers;

import java.math.BigDecimal;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab.crud.entities.Lamp;
import com.lab.crud.entities.Orders;
import com.lab.crud.entities.OrderDetail;
import com.lab.crud.services.CartService;
import com.lab.crud.services.LampService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService Csert;
	@Autowired
	private LampService Lser;

	private Orders order = new Orders();

	@GetMapping("/add")
	public String add(String id,Model model) {
		try {
			Lamp l = Lser.findById(id);
			if (l.getQuantity() > 0) {
				OrderDetail cd = Csert.findByLampId(l.getId_lamp());
				if (cd == null) {
					OrderDetail c = new OrderDetail();
					c.setLamp(l);
					c.setPrice(l.getPrice());
					c.setQuantity(1);
					Csert.addCart(c);
				} else {
					cd.setQuantity(cd.getQuantity() + 1);
					Csert.updateCart(cd);
					model.addAttribute("messageShop1", "Sản Phẩm Đã thêm vào giỏ hàng");
				}
			} else {
				model.addAttribute("messageShop", "Sản Phẩm này đã được bán hết");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/shop";
	}

	@GetMapping("/index")
	public String index(ModelMap map) {
		List<OrderDetail> list = Csert.getAll();
		map.addAttribute("list", list);
		int tongsp = 0;
		double tongDouble = 0;
		for (OrderDetail o : list) {
			tongDouble += Double.parseDouble(String.valueOf(o.getQuantity()))
					* Double.parseDouble(String.valueOf(o.getPrice()));

		}
		
		map.addAttribute("tongsp", list.size());
		map.addAttribute("tongth", BigDecimal.valueOf(tongDouble));
		map.addAttribute("tamtinh", BigDecimal.valueOf(tongDouble));
		
		map.addAttribute("view", "/WEB-INF/cart/index.jsp");
		return "layout";
	}

	@GetMapping("/delete")
	public String delete(ModelMap map, Long id) {
		try {
			Csert.deleteCart(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/cart/index";
	}

	@GetMapping("/increase/{id}")
	public String increaseAmount(Model model, @PathVariable("id") Long id) throws Exception {
		OrderDetail orderDetail = Csert.findId(id);
		if((orderDetail.getQuantity()+1) > orderDetail.getLamp().getQuantity()) {
			model.addAttribute("messageCart", "Vượt quá số lượng sản phẩm");
		}else {
			Csert.increaseAmount(id);
		}
		
		return "forward:/cart/index";
	}

	@GetMapping("/decrease/{id}")
	public String decreaseAmount(Model model, @PathVariable("id") Long id) throws Exception {
		OrderDetail orderDetail = Csert.findId(id);
		if(orderDetail.getQuantity()-1<1) {
			model.addAttribute("messageCart", "Số lượng sản phẩm phải lớn hơn 0");
		}else {
			Csert.decreaseAmount(id);
		}
		
		return "redirect:/cart/index";
	}

}
