package com.capgemini.medicalshopcollection.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capgemini.medicalshopcollection.beans.CartBean;
import com.capgemini.medicalshopcollection.beans.ProductBean;
import com.capgemini.medicalshopcollection.database.CartData;
import com.capgemini.medicalshopcollection.database.ProductTable;


public class CartDAOImpl implements CartDAO {
	CartData cartData = new CartData();
	HashMap<Integer, CartBean> cartDb = cartData.cartDb;
	ProductTable productTable = new ProductTable();
	HashMap<Integer, ProductBean> productDb = productTable.productDb;
	
	
	@Override
	public boolean addIntoCart(CartBean cartBean) {
		if (cartDb.containsKey(cartBean.getCartId()) != true) {
			cartDb.put(cartBean.getCartId(), cartBean);
			return true;
		}
		return false;
	}


	@Override
	public List<CartBean> getAllProducts() {
		List<CartBean> productsList = new ArrayList<CartBean>();
		for (int cartId : cartDb.keySet()) {
			CartBean cartBean = cartDb.get(cartId);
			productsList.add(cartBean);
		}
		return productsList;
	}


	@Override
	public double totalBill(int userId) {
		double totalBill = 0.0;
		for (Integer cartId : cartDb.keySet()) {
			CartBean cartBean = cartDb.get(cartId);
			
			//Checking userId of Logged In user 
			if (cartBean.getUserId() == userId) {	
				//calculating total bill for Logged in user
				totalBill = totalBill + cartBean.getPrice();
			}

		}
		return totalBill;
	}//End of totalBill()

}//End of Class
