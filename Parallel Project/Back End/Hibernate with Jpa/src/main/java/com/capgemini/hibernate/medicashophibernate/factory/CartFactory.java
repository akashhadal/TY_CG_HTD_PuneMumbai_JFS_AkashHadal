package com.capgemini.hibernate.medicashophibernate.factory;

import com.capgemini.hibernate.medicashophibernate.dao.CartDao;
import com.capgemini.hibernate.medicashophibernate.dao.CartImpl;

public class CartFactory {
	
	private CartFactory() {
	}
	
	public static CartDao getCartInstance() {
		CartDao dao=new CartImpl();
		return dao;
	}// end of getCartInstance()
}// end of 
