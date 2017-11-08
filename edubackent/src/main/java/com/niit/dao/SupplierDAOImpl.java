package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	

	public List<Supplier> list() {
		
		Session session=sessionFactory.openSession();
	List<Supplier> list=	session.createQuery("from Supplier").list() ;
	session.close();
	return list;
	}

	public Supplier getSupplierByID(String id) {
		return  (Supplier) sessionFactory.openSession().get(Supplier.class, id);
		
	}

	public boolean save(Supplier supplier) {
		try
		{
			Session session =sessionFactory.openSession();
			session.save(supplier);
			session.flush();
	
	return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) {
		try {
			Session session =sessionFactory.openSession();
			session.update(supplier);
			session.flush();
	session.close();
			return true;
		}catch (Exception e)
		{
			e.printStackTrace();
			return false;
			
		}	
	}


	public boolean delete(Supplier supplier) {
		try {
			sessionFactory.openSession().delete(supplier);
			return true;
		}catch (Exception e)
		{
			e.printStackTrace();
			return false;
			
		}	
	}


	@Override
	public boolean delete(String id)
	{
	try {
		Session session =sessionFactory.openSession();
		session.delete(getSupplierByID(id));
		session.flush();
		session.close();
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}

}
