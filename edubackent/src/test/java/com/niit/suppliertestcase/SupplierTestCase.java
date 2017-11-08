package com.niit.suppliertestcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {

	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplier = (Supplier) context.getBean("supplier");
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
	}
	
	 @Test
	   public void updateSupplierTestCase()
	   {
		   
		   supplier.setId("CG02032017");
		   supplier.setName("new Category");
		   supplier.setAddress("This is Women category");
		   
		   boolean flag = supplierDAO.update(supplier);
		   
		   Assert.assertEquals( "updateSupplierTestCase" ,true, flag);
		   
		   
	   }
	 
	 
	 @Test
	   public void deleteSupplier()
	   {
		   supplier.setId("CG02032017");
		   
		   boolean flag = supplierDAO.delete(supplier);
		   
		   Assert.assertEquals( "deleteSupplierTestCase" ,true, flag);
		   
		   
	   }
	   
	 
	 @Test
	   public void getAllSupplierTestCase()
	   
	   {
		   
		  int recordsFromDAO =  supplierDAO.list().size();
		  
		  assertEquals("getAllSupplierTestCase" ,7 , recordsFromDAO);
		   
	   }
	   
}
