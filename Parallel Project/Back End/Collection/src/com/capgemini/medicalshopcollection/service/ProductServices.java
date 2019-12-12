package com.capgemini.medicalshopcollection.service;

import java.util.List;

import com.capgemini.medicalshopcollection.beans.ProductBean;


public interface ProductServices {

	public boolean searchProduct(int productId);

	public boolean addProduct(ProductBean productBean);

	//public boolean updateProduct(ProductBean productBean);

	public boolean removeProduct(int productId);

	public List<ProductBean> getAllProducts();


	public boolean updateProduct(int productId, double price, String available);
	
	public ProductBean getProduct(int productId);

}// End of interface
