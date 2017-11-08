package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Shipping;
import com.niit.model.User;

@Transactional
@Repository
public class ShippingDAOImpl implements ShippingDAO {

	@Autowired
	private SessionFactory sessionFactory;
    
	
	@Override
	public List<Shipping> list() {
		return sessionFactory.openSession().createQuery("from Shipping").list() ;
	}

	@Override
	public boolean save(Shipping shipping) {
		try
		{
				Session session =sessionFactory.openSession();
				Shipping s = (Shipping)session.createQuery("from Shipping where username='"+shipping.getUsername()+"'").uniqueResult();
				if(s!=null){
				session.delete(s);
				session.flush();
				}
				session.save(shipping);
				
				session.flush();
		
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
	}

	@Override
	public Shipping getShippingByID(int id) {
		return (Shipping) sessionFactory.openSession().get(Shipping.class,id);
	}

}
