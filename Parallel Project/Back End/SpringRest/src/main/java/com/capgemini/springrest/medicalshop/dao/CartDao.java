package com.capgemini.springrest.medicalshop.dao;

import java.util.List;

import com.capgemini.springrest.medicalshop.beans.CartBean;
import com.capgemini.springrest.medicalshop.beans.OrderBean;
import com.capgemini.springrest.medicalshop.beans.Payment;


public interface CartDao {

	public boolean addProduct(int uId, String getProductName);

	public boolean deleteProduct(int cartId, int userId);

	public Payment payment(int uId,String address);
	
	public double totalBill(int userId);

	public List<CartBean> getCart(int uId);

	public boolean addOrder(OrderBean orderBean);

	public List<OrderBean> viewOrder(int userId);

	public boolean insertIntoCart(OrderBean orderBean);
}
