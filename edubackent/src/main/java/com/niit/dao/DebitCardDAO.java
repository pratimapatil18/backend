package com.niit.dao;

import java.util.List;

import com.niit.model.DebitCard;



public interface DebitCardDAO {

	public List<DebitCard> list();
	
	public DebitCard getDebitCardByID(int id);
		public boolean save(DebitCard debitcard);

	
}
