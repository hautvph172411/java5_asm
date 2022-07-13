package com.lab.crud.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "lamps")
public class Lamp {
	@Id
	@Column(name="id_lamp", nullable = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_lamp;
	@Column(name="name", nullable = true)
	@Nationalized
	private String name;
	@Column(name="createdDate", nullable = true)
	private Date createdDate;
	@Column(name="origin", nullable = true)
	private LampOrigin origin;
	@Column(name="img", nullable = true)
	private String img;
	@Column(name="brand", nullable = true)
	private LampBrand brand;
	@Column(name="color", nullable = true)
	private String color;
	@Column(name="quantity", nullable = true)
	private Integer quantity;
	@Column(name="price", nullable = true)
	private BigDecimal price;
	@OneToMany(mappedBy = "lamp")
	List<OrderDetail> listOrderDetail;
	public Integer getId_lamp() {
		return id_lamp;
	}
	public void setId_lamp(Integer id_lamp) {
		this.id_lamp = id_lamp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate() {
		this.createdDate = new Date();
	}
	public LampOrigin getOrigin() {
		return origin;
	}
	public void setOrigin(LampOrigin origin) {
		this.origin = origin;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public LampBrand getBrand() {
		return brand;
	}
	public void setBrand(LampBrand brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	

}
