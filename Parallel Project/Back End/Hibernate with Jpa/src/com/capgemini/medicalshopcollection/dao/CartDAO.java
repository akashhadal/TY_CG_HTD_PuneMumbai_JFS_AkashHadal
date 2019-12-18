package com.capgemini.medicalshopcollection.dao;

import java.util.List;

import com.capgemini.medicalshopcollection.beans.CartBean;


public interface CartDAO {
	public boolean addIntoCart(CartBean cartBean);
	public List<CartBean> getAllProducts();
	public double totalBill(int userId);

}//End of interface
