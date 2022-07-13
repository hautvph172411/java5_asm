package com.lab.crud.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@Column(name="id_user", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    
	@Column(name="fullname", nullable = true)
    private String fullname;
    
	@Column(name="role", nullable = true)
    private Boolean role;
    
	@Column(name="gmail", nullable = true)
    private String gmail;
    
	@Column(name="pass", nullable = true)
    private String pass;
	@OneToMany(mappedBy="user")
	private List<Orders> listOrder;
	
	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	
}
