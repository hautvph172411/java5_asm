package com.lab.crud.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.crud.entities.OrderDetail;
import com.lab.crud.repositories.IOrderDetailRepository;


@Service
public class OrderDetailService {
	@Autowired
	private IOrderDetailRepository repository;
	
	public OrderDetail add(OrderDetail od) {
		return repository.save(od);
	}
	public void delete(OrderDetail od) {
		repository.delete(od);
	}
	
}
