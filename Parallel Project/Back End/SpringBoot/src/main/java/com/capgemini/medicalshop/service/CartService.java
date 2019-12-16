package com.capgemini.medicalshop.service;

import java.util.List;

import com.capgemini.medicalshop.beans.CartBean;
import com.capgemini.medicalshop.beans.OrderBean;
import com.capgemini.medicalshop.beans.Payment;

public interface CartService {

	public boolean addProduct(int uId,String getProductName);

	public boolean deleteProduct(int cartId,int userId);
	
	public Payment payment(int uId,String address);
	
	public double totalBill(int userId);
	
	public List<CartBean> getCart(int uId);
	
	public boolean addOrderToHistory(OrderBean orderBean);
	
	public List<OrderBean> viewOrder(int userId);
	
}//End of cartService()
