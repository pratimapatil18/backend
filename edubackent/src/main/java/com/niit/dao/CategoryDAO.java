package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDAO {

	public List<Category> list();
	

	public boolean save(Category category);

	// update category

	public boolean update(Category category);

	// delete category by id

	public boolean delete(String id);

	// delete category by category

	public boolean delete(Category category);

	// get category by id

	public Category getCategoryByID(String id);

	// get category by name
	public Category getCategoryByName(String name);

	
}
