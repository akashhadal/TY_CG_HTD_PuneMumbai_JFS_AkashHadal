package com.capgemini.medicalshopcollection.service;

import java.util.List;

import com.capgemini.medicalshopcollection.beans.ProductBean;
import com.capgemini.medicalshopcollection.dao.ProductDAO;
import com.capgemini.medicalshopcollection.dao.ProductDAOImpl;


public class ProductServicesImpl implements ProductServices {
	//Create object of productDAO
	ProductDAO productDAO = new ProductDAOImpl();

	@Override
	public boolean addProduct(ProductBean productBean) {
		return productDAO.addProduct(productBean);
	}

	@Override
	public boolean searchProduct(int productId) {
		return productDAO.searchProduct(productId);
	}

	@Override
	public boolean removeProduct(int productId) {
		return productDAO.removeProduct(productId);
	}

	@Override
	public List<ProductBean> getAllProducts() {
		return productDAO.getAllProducts();
	}


	@Override
	public boolean updateProduct(int productId, double price, String available) {
		return productDAO.updateProduct(productId, price, available);
	}

	@Override
	public ProductBean getProduct(int productId) {
		return productDAO.getProduct(productId);
	}

}//End of Class
