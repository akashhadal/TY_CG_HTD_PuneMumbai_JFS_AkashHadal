package com.capgemini.medicalshop.dao;

import java.util.List;

import com.capgemini.medicalshop.beans.ProductBean;



public interface ProductDao {
	
	public boolean addProduct(ProductBean productBean);
	
	public boolean updateProduct(ProductBean productBean);
	
	public boolean deleteProduct(int productId);
	
	public List<ProductBean> getAllProduct();

}// End of Interface
