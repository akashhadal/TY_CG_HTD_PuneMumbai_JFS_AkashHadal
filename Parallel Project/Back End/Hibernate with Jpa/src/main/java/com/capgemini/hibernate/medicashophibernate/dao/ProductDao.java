package com.capgemini.hibernate.medicashophibernate.dao;

import java.util.List;

import com.capgemini.hibernate.medicashophibernate.beans.ProductBean;

public interface ProductDao {
	
	public boolean addProduct(int pId,String name,String category,double price);
	
	public boolean updateProduct(int pId,String name,String category,double price);
	
	public boolean deleteProduct(int pId);
	
	public List<ProductBean> getAllProduct();

}// End of Interface
