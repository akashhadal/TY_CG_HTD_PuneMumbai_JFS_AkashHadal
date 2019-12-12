package com.capgemini.hibernate.medicashophibernate.dao;

import java.util.List;

import com.capgemini.hibernate.medicashophibernate.beans.CartBean;
import com.capgemini.hibernate.medicashophibernate.beans.OrderBean;

public interface CartDao {
	
	public boolean addProduct(int uId);

	public boolean deleteProduct(String pName,int userId);
	
	public double payment(int uId);
	
	public List<OrderBean> orderBeans(int userId);
	
	public boolean insertIntoCart(OrderBean orderBean);
}
