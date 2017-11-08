package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.model.Contact;


@Transactional
@Repository
public class ContactDAOImpl implements ContactDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
    
	
	@Override
	public List<Contact> list() {
		return sessionFactory.openSession().createQuery("from Contact").list() ;
	}

	@Override
	public boolean save(Contact contact) {
		try
		{
				Session session =sessionFactory.openSession();
				session.save(contact);
				session.flush();
		
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
	}
}
