package com.niit.dao;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.Category;
import com.niit.model.Product;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO{


	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Product> list() {
		Session session=sessionFactory.openSession();
		List<Product> list=	session.createQuery("from Product").list() ;
		session.close();
		return list;
	}

	public boolean save(Product product) {
		try
		{
			Session session =sessionFactory.openSession();
			session.save(product);
			
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
	
	
	public boolean update(Product product) {
		try {
			Session session =sessionFactory.openSession();
			session.update(product);
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
			session.delete(getProductByID(id));
			session.flush();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Product product) {
		try {
			sessionFactory.openSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public Product getProductByID(String id) {
		//select * from Category where id ='mobile'
		//  return	(Category)  sessionFactory.getCurrentSession().get(Category.class, id);
		  
		 return  (Product) sessionFactory.openSession().get(Product.class, id);
	}

	public Product getProductByName(String name) {
		 return  (Product) sessionFactory.openSession().createQuery("from Product where name = '"+name + "'").list().get(0);
			

	}
	
	@SuppressWarnings("deprecation")
	public void storeFile(Product product, HttpServletRequest request)
	{
		System.out.println(request.getRealPath("/"));
		 String path=request.getRealPath("/")+"resources\\images\\"+product.getImage();
		 System.out.println(path);
		MultipartFile file= product.getFile();
	
		if (!file.isEmpty()) {
			
		try{
		byte[] bytes =file.getBytes();
		System.out.println(file.getOriginalFilename());
		
		
		File serverFile = new File(path);
		serverFile.createNewFile();
	
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
			
	}
	}

	@Override
	public List<Product> Search(String prdName) {
		String hql = "from Product where name like '%"+prdName+"%'";
		Query query = sessionFactory.openSession().createQuery(hql);
		
		return query.list();
	}	
}
