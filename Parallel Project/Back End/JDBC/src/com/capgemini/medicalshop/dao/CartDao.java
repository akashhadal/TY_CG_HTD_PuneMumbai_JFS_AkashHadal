package com.capgemini.medicalshop.dao;

import com.capgemini.medicalshop.bean.CartBean;
import com.capgemini.medicalshop.bean.OrderBean;

public interface CartDao {
	
	public CartBean addProduct(int uId);

	public CartBean deleteProduct(String pName);
	
	public CartBean payment(int uId,String Address);
	
	public boolean addOrder(OrderBean orderBean);
}
