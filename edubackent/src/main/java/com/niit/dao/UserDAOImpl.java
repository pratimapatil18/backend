package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;


@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	
	public List<User> list() {
	return sessionFactory.openSession().createQuery("from User").list();	
	}

	public User getUser(String id) {
		return (User) sessionFactory.openSession().get(User.class, id);
	}

	public boolean save(User user) {
		try
		{
			Session session =sessionFactory.openSession();
			session.save(user);
			session.flush();
				return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		try
		{
			Session session =sessionFactory.openSession();
			session.update(user);
			session.flush();
	
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "deprecation"})
	
	public boolean validate(String mail, String password) {
		String hql="from User where mail='"+mail+"' and password='"+password+"'";
		if(sessionFactory.openSession().createQuery(hql).uniqueResult()==null)
		{
			return false;
		}
		return true;
	}


	@Override
	public User getUserById(String id) {
		return (User) sessionFactory.openSession().get(User.class,id);
	}


	@Override
	public User getUserByMail(String mail) {
		return (User) sessionFactory.openSession().createQuery("from User where mail='"+mail+"'").uniqueResult();
	}
	

}
