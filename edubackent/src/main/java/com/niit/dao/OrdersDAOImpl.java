package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Orders;

@Transactional
@Repository
public class OrdersDAOImpl implements OrdersDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Orders> list() {
		return sessionFactory.openSession().createQuery("from Orders").list() ;
	}

	@Override
	public boolean save(Orders orders) {
		try
		{
				Session session =sessionFactory.openSession();
				session.save(orders);
				session.flush();
				session.close();
		
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
	}
	
}
