package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.DebitCard;

@Transactional
@Repository
public class DebitCardDAOImpl implements DebitCardDAO{

	@Autowired
	private SessionFactory sessionFactory;
    
	
	@Override
	public List<DebitCard> list() {
		return sessionFactory.openSession().createQuery("from DebitCard").list() ;
	}

	@Override
	public DebitCard getDebitCardByID(int id) {
		return (DebitCard) sessionFactory.openSession().get(DebitCard.class,id);
	}

	@Override
	public boolean save(DebitCard debitcard) {
		try
		{
				Session session =sessionFactory.openSession();
				session.save(debitcard);
				
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
