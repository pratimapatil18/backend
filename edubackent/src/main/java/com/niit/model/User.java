package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="user")
@Component
public class User implements Serializable {	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private String id;
	@Column(name="name")
	private String name;
	@Column
	@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	private String password;
	@Column(unique=true, nullable=false)
	@NotEmpty(message="Login UserName With Your Email-Id")
	private String mail;
	@Column
	private String contact;
	@Column
	private String role;
	
	public String getId() {
		return id;
	}
	public String getContact() {
		return contact;
	}
	public String getMail() {
		return mail;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
