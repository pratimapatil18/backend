package com.niit.usertestcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CORBA.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

import junit.framework.Assert;

public class UserTestCase {

	@Autowired
	private static ApplicationContext context;
	
	@Autowired
	private static User user;
	
	@Autowired 
	private static UserDAO userDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		user=(User)context.getBean("user");
		userDAO=(UserDAO)context.getBean("userDAO");
	}
  
	
	@Test
	public void validateCredentialsTestCase()
	{
		boolean flag=userDAO.validate("niit", "niit");
		
		Assert.assertEquals("validateCredentialsTestCase",true,flag);
	
	}
	
	
	
	
	
}
