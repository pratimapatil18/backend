package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class DebitCard implements Serializable  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;	
	@Column(name="userid")
	private String username;
	@Column
	//@Size(max=16)
	private int cardno;
	@Column
	private String expmonth;
	@Column
	private int expyear;
	@Transient
	@Size(min=3)
	private String cvv;
	@Transient
	@Size(min=4)
	private String atmpin;
	
	@Column
	private String cardname;
	public int getId() {
		return id;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getAtmpin() {
		return atmpin;
	}
	public void setAtmpin(String atmpin) {
		this.atmpin = atmpin;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCardno() {
		return cardno;
	}
	public void setCardno(int cardno) {
		this.cardno = cardno;
	}
	public String getExpmonth() {
		return expmonth;
	}
	public void setExpmonth(String expmonth) {
		this.expmonth = expmonth;
	}
	public int getExpyear() {
		return expyear;
	}
	public void setExpyear(int expyear) {
		this.expyear = expyear;
	}
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	
}
