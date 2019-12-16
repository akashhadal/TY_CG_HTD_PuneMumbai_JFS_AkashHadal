package com.capgemini.medicalshop.dao;

import java.util.List;

import com.capgemini.medicalshop.bean.CartBean;
import com.capgemini.medicalshop.bean.OrderBean;

public interface CartDao {
	
	public CartBean addProduct(int uId);

	public CartBean deleteProduct(String pName);
	
	public CartBean payment(int uId,String Address);
	
	public boolean addOrder(OrderBean orderBean);
	
	public List<OrderBean> list(int userId);
	
	public List<CartBean> showCart(int userId);
}
