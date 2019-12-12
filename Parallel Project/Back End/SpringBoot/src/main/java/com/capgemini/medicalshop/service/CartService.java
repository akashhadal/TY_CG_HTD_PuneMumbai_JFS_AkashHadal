package com.capgemini.medicalshop.service;

import java.util.List;

import com.capgemini.medicalshop.beans.CartBean;
import com.capgemini.medicalshop.beans.OrderBean;
import com.capgemini.medicalshop.beans.Payment;

public interface CartService {

	public boolean addProduct(int uId,String getProductName);

	public boolean deleteProduct(String pName,int userId);
	
	public Payment payment(int uId,String address);
	
	public List<CartBean> getCart(int uId);
	
	public boolean addOrder(OrderBean orderBean);
	
	public List<OrderBean> viewOrder(int userId);
	
}//End of cartService()
