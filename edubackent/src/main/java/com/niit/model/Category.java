package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="Category")
public class Category implements Serializable {

	
	@Id
	@NotBlank
	private String id;
	@Column(name="name")
	@Size(min=3)
	private String name;
	@Column
	@NotBlank
	private String description;
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
