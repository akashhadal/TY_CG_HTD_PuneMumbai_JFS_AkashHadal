package com.capgemini.medicalshopcollection.database;

import java.util.HashMap;

import com.capgemini.medicalshopcollection.beans.CartBean;


public class CartData {
	public static HashMap<Integer, CartBean> cartDb = new HashMap<>();
	
	public CartData() {
		CartBean cartBean1 = new CartBean();
		cartBean1.setCartId(1);
		cartBean1.setUserId(3);
		cartBean1.setUserName("Diksha");
		cartBean1.setProductId(101);
		cartBean1.setProductName("crosin");
		cartBean1.setPrice(150);
		cartBean1.setQuantity(10);
		cartDb.put(cartBean1.getCartId(), cartBean1);
		
		
		
	}//End of CartData()
	

}//End of Class
