package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {
	
	public List<User> list();
	public User getUser(String id);
	public boolean save(User user);
	public boolean update(User user);
	public boolean validate(String mail, String password);
	public User getUserById(String id);
    public User getUserByMail(String mail);
}
