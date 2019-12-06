package com.capgemini.springmvc.medicalshop.dao;

import java.util.List;

import com.capgemini.springmvc.medicalshop.beans.CartBean;
import com.capgemini.springmvc.medicalshop.beans.Payment;

public interface CartDao {
	
	public boolean addProduct(int uId,String getProductName);

	public boolean deleteProduct(String pName,int userId);
	
	public Payment payment(int uId,String button);
	
	public List<CartBean> cart(int userId);
	
}
