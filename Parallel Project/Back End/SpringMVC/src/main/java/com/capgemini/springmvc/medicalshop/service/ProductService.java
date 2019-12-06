package com.capgemini.springmvc.medicalshop.service;

import java.util.List;

import com.capgemini.springmvc.medicalshop.beans.ProductBean;

public interface ProductService {

	public boolean addProduct(ProductBean productBean);

	public boolean updateProduct(ProductBean productBean);

	public boolean deleteProduct(int pId);

	public List<ProductBean> getAllProduct();

}// End of Interface
