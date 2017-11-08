package com.niit.dao;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Supplier;
import com.niit.model.User;

public interface SupplierDAO {

	public List<Supplier> list();
	public Supplier getSupplierByID(String id);
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	
	public boolean delete(String id);
}
