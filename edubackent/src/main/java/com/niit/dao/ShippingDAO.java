package com.niit.dao;

import java.util.List;


import com.niit.model.Shipping;

public interface ShippingDAO {
public List<Shipping> list();
	
public Shipping getShippingByID(int id);
	public boolean save(Shipping shipping);

}
