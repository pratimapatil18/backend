package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="supplier")
public class Supplier implements Serializable {	
	@Id
	@NotBlank
	private String id;
	@Column(name="name")
	@Size(min=3)
	private String name;
	@Column
	@NotBlank
	private String address;
	
	public String getId() {
		return id;
	}
	public String getAddress() {
		return address;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

}
