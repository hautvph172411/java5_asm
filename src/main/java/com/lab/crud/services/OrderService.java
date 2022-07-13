package com.lab.crud.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.crud.entities.Orders;
import com.lab.crud.repositories.IOrderRepository;



@Service
public class OrderService {
	@Autowired
	private IOrderRepository repository;
	
	public Orders addOrder(Orders order) {
		
		return repository.save(order);
	}
	
	
	public Orders updateCart(Orders cart) throws Exception {
			return repository.save(cart);
	}
	
	public Orders deleteCart(Long id) throws Exception {
	      Optional<Orders> cart = repository.findById(id);
	      if(cart.isPresent()) {
	    	  repository.delete(cart.get());
	    	  return cart.get();
	      }else {
			throw new Exception("Không tìm thấy id");
		}
	}
	
	public List<Orders> getAll(){
		return repository.findAll();
	}
	
	public Orders findId(Long id) {
		Optional<Orders> cart = repository.findById(id);
		return cart.isPresent()?cart.get():null;
	}
}
