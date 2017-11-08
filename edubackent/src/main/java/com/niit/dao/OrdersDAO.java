package com.niit.dao;

import java.util.List;

import com.niit.model.Orders;



public interface OrdersDAO {

	public List<Orders> list();
	
	public boolean save(Orders orders );
}
