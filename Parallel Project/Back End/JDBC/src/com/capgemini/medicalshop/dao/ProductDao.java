package com.capgemini.medicalshop.dao;

import com.capgemini.medicalshop.bean.ProductBean;

public interface ProductDao {
	
	public ProductBean addProduct(int pId,String name,String category,double price);
	
	public ProductBean updateProduct(int pId);
	
	public ProductBean deleteProduct(int pId);
	
	public ProductBean getAllProduct();

}// End of Interface
