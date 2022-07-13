package com.lab.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.crud.entities.Orders;



public interface IOrderRepository extends JpaRepository<Orders, Long> {

}
