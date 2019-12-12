package com.capgemini.medicalshopcollection.dao;

import java.util.List;

import com.capgemini.medicalshopcollection.beans.ProductBean;


public interface ProductDAO {
	public boolean searchProduct(int productId);
	public boolean addProduct(ProductBean productBean);
	public boolean updateProduct(int productId, double price, String available);
	public boolean removeProduct(int productId);
	
	public List<ProductBean> getAllProducts();
	
	
	public ProductBean getProduct(int productId);
}//End of interface
