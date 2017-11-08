package com.niit.dao;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Contact;

public interface ContactDAO {

public List<Contact> list();
	

	public boolean save(Contact contact);

	

	
	
	
	
}
