package com.lab.crud.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lab.crud.entities.Orders;
import com.lab.crud.entities.OrderDetail;



public interface ICartRepository extends JpaRepository<OrderDetail, Long> {
	@Query("select o from OrderDetail o where o.lamp.id_lamp = ?1 ")
    OrderDetail findByLampId(Integer lampId);
    
}
