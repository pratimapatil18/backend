package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.model.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
    
		
	public List<Category> list() {
		Session session=sessionFactory.openSession();
		List<Category> list=session.createQuery("from Category").list() ;
		session.close();
		return list;
	}

	public boolean save(Category category) {
		try
		{
				Session session =sessionFactory.openSession();
				session.save(category);
				session.flush();
		
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
	}

	public boolean update(Category category) {
		try {
			Session session =sessionFactory.openSession();
			session.update(category);
			session.flush();
			session.close();
			return true;
		}catch (Exception e)
		{
			e.printStackTrace();
			return false;
			
		}	
	}

	public boolean delete(String id) {
		try {
			Session session =sessionFactory.openSession();
			session.delete(getCategoryByID(id));
			session.flush();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Category category) {
		try {
			sessionFactory.openSession().delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public Category getCategoryByID(String id) {
		//select * from Category where id ='mobile'
		//  return	(Category)  sessionFactory.getCurrentSession().get(Category.class, id);
		  
		  return  (Category) sessionFactory.openSession().get(Category.class, id);
			
	}

	public Category getCategoryByName(String name) {
		 return  (Category) sessionFactory.openSession().createQuery("from Category where name = '"+name + "'").list().get(0);
			

	}
	

}
