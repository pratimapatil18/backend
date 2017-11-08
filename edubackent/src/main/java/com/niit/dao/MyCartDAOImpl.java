package com.niit.dao;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.MyCart;
import com.niit.model.Shipping;

@Transactional
@Repository

public class MyCartDAOImpl implements MyCartDAO {
	
	//private static Logger log = LoggerFactory.getLogger(MyCartDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public MyCartDAOImpl() {

	}

	public MyCartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<MyCart> list(String userID) {
		System.out.println("mycart");
		//log.debug("Starting of the method list");
		String hql = "from MyCart where user_name=" + "'" + userID + "'  and status = " + "'N'";
		Session session = sessionFactory.openSession();
		Query query=		session.createQuery(hql);
		////log.debug("Ending of the method list");
		List<MyCart> l= query.list();
	session.close();
		return l;

	}

	public void save(MyCart mycart) {
		//log.debug("Starting of the method save");
			mycart.setId(getMaxId());
			mycart.setDate_added(new java.util.Date());
			mycart.setQuantity(1);
			System.out.println(mycart.getId());
		Session session =sessionFactory.openSession();
		session.save(mycart);
		session.flush();
		session.close();
	//	sessionFactory.openSession().save(mycart);
	//	log.debug("Ending of the method save");
	}


	public double getTotalAmount(String userID) {
		//log.debug("Starting of the method getTotalAmount");
		String hql = "select sum(price) from MyCart where user_name=" + "'" + userID + "' " + "  and status = " + "'N'";
		//log.debug("hql" + hql);

		Query query = sessionFactory.openSession().createQuery(hql);
		//log.debug("Ending of the method getTotalAmount");
		return (double) query.uniqueResult();

	}


	public MyCart getCart(String userID, String productName)
	{
		String hql="from MyCart where user_name=? and product_name=?";
		Query query=sessionFactory.openSession().createQuery(hql);
		query.setString(0, userID);
		query.setString(1,productName);
		return (MyCart) query.uniqueResult();
		
	}
	
	public int getMaxId() {
	//	log.debug("->->Starting of the method getMaxId");
		Session session=sessionFactory.openSession();
		int maxID = 100;
		try {
			String hql = "select max(id) from MyCart";
			
			Query query = session.createQuery(hql);
			maxID = (int) query.uniqueResult();
		} catch (Exception e) {
		//	log.debug("It seems this is first record. setting initial id is 100 :");
			maxID = 100;
			e.printStackTrace();
		}
		session.close();
	//	log.debug("Max id :" + maxID);
		return (maxID + 1);

	}

	@Override
	public boolean delete(MyCart mycart) {
		try {
			sessionFactory.openSession().delete(mycart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

	@Override
	public boolean delete(int id) {
		try {
			Session session =sessionFactory.openSession();
			session.delete(getCartByID(id));
			session.flush();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MyCart getCartByID(int id) {
		 return   (MyCart) sessionFactory.openSession().get(MyCart.class, id);
			
	}

	public boolean deletebyId(String username) {
		Session session =sessionFactory.openSession();
		try{
		
		List<MyCart>mlt = (List)session.createQuery("from MyCart where user_name='"+username+"'").list();
		if(!mlt.isEmpty())
		{
			for(MyCart mt : mlt){
				
						session.delete(mt);
						session.flush();
			}
		}
		
		
		
		
		}
		catch (Exception e) {
			
			e.printStackTrace();
			session.close();
			return false;
			
		}
		session.close();
		return true;
		
	}

	
	
}
