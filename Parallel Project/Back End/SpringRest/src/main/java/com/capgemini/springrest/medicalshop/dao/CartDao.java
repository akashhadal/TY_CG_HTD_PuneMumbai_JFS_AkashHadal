package com.capgemini.springrest.medicalshop.dao;

import java.util.List;

import com.capgemini.springrest.medicalshop.beans.CartBean;
import com.capgemini.springrest.medicalshop.beans.OrderBean;
import com.capgemini.springrest.medicalshop.beans.Payment;

public interface CartDao {
	
	public boolean addProduct(int uId,String getProductName);

	public boolean deleteProduct(String pName,int userId);
	
	public Payment payment(int uId,String button,String address);
	
	public List<CartBean> cart(int userId);
	
	public boolean addOrder(OrderBean orderBean);
	
}
