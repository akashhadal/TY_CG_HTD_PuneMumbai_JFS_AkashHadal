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
		cartBean1.setProductName("Myaxyl Capsules");
		cartBean1.setPrice(150);
		cartBean1.setQuantity(10);
		cartDb.put(cartBean1.getCartId(), cartBean1);
		
		CartBean cartBean2 = new CartBean();
		cartBean2.setCartId(2);
		cartBean2.setUserId(4);
		cartBean2.setUserName("Diksha");
		cartBean2.setProductId(102);
		cartBean2.setProductName("Kudos IME9");
		cartBean2.setPrice(80);
		cartBean2.setQuantity(5);
		cartDb.put(cartBean2.getCartId(), cartBean2);
		
		
		
	}//End of CartData()
	

}//End of Class
