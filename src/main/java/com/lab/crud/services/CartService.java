package com.lab.crud.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.crud.entities.OrderDetail;
import com.lab.crud.repositories.ICartRepository;



@Service
public class CartService {
	@Autowired
	private ICartRepository repository;
	
	public OrderDetail addCart(OrderDetail cart) {
		return repository.save(cart);
	}
	
	public OrderDetail findByLampId(Integer lampId) {
		return repository.findByLampId(lampId);
	}
	
	public OrderDetail updateCart(OrderDetail cart) throws Exception {
			return repository.save(cart);
	}
	
	public OrderDetail deleteCart(Long id) throws Exception {
	      Optional<OrderDetail> cart = repository.findById(id);
	      if(cart.isPresent()) {
	    	  repository.delete(cart.get());
	    	  return cart.get();
	      }else {
			throw new Exception("Không tìm thấy id");
		}
	}
	
	public List<OrderDetail> getAll(){
		return repository.findAll();
	}
	
	public OrderDetail findId(Long id) throws Exception {
		Optional<OrderDetail> cart = repository.findById(id);
		if(cart.isPresent()) {
			return cart.get();
		}else {
			throw new Exception("Không tìm thấy");
		}
	}
	public OrderDetail increaseAmount(Long id) throws Exception {
		OrderDetail orderDetail= findId(id);
		orderDetail.setQuantity(orderDetail.getQuantity()+1);
		repository.save(orderDetail);
		return orderDetail;
	}
	public OrderDetail decreaseAmount(Long id) throws Exception {
		OrderDetail orderDetail= findId(id);
		orderDetail.setQuantity(orderDetail.getQuantity()-1);
		repository.save(orderDetail);
		return orderDetail;
	}
}
