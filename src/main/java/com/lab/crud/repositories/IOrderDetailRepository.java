package com.lab.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.crud.entities.OrderDetail;



public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	
}
