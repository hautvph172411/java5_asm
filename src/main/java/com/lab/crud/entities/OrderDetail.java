package com.lab.crud.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class OrderDetail {
	@Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_order_detail;
    @Column
    private BigDecimal price;
    @Column
    private int quantity;
    @ManyToOne @JoinColumn(name="id_order")
    private Orders order;
    @ManyToOne @JoinColumn(name="id_lamp")
    private Lamp lamp;
	public Long getId_order_detail() {
		return id_order_detail;
	}
	public void setId_order_detail(Long id_order_detail) {
		this.id_order_detail = id_order_detail;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Lamp getLamp() {
		return lamp;
	}
	public void setLamp(Lamp lamp) {
		this.lamp = lamp;
	}
    
    
}
