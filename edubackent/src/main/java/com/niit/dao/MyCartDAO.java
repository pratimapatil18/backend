package com.niit.dao;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.MyCart;



public interface MyCartDAO {

	public List<MyCart> list(String UserID);
	public void save(MyCart mycart);
	public boolean delete(MyCart mycart );
	public boolean delete(int id);
	
	public boolean deletebyId(String username);
	
	public MyCart getCartByID(int id);
	public double getTotalAmount(String UserId);
	public int getMaxId();
	public MyCart getCart(String userID, String productName);
	
}
