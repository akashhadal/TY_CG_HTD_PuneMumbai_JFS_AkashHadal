package com.capgemini.medicalshop.factory;

import com.capgemini.medicalshop.dao.CartDao;
import com.capgemini.medicalshop.dao.CartImpl;


public class CartFactory {
	
	private CartFactory() {
	}
	
	public static CartDao getCartInstance() {
		CartDao cartDao = new CartImpl();
		return cartDao;
	}// end of getCartInstance()
}// end of 
