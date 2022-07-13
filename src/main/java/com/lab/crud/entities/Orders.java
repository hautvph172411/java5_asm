package com.lab.crud.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	@Id
	@Column(name="id_order", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="day_create_bill", nullable = true)
	private Date createdDate;
	@Column(name="total_money", nullable = true)
	private String total_money;
	@ManyToOne@JoinColumn(name = "id_user")
	private Users user;
	@OneToMany(mappedBy="order")
	List<OrderDetail> listOrderdetail;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getTotal_money() {
		return total_money;
	}
	public void setTotal_money(String total_money) {
		this.total_money = total_money;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public List<OrderDetail> getListOrderdetail() {
		return listOrderdetail;
	}
	public void setListOrderdetail(List<OrderDetail> listOrderdetail) {
		this.listOrderdetail = listOrderdetail;
	}
	public Orders(Long id, Date createdDate, String total_money, Users user, List<OrderDetail> listOrderdetail) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.total_money = total_money;
		this.user = user;
		this.listOrderdetail = listOrderdetail;
	}
	public Orders() {
		super();
	}
	
	
}
