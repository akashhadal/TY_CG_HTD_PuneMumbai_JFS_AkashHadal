package com.capgemini.springmvc.medicalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springmvc.medicalshop.beans.ProductBean;
import com.capgemini.springmvc.medicalshop.dao.ProductDao;

@Service
public class ProductServiceImpli implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public boolean addProduct(ProductBean productBean) {
		
		return dao.addProduct(productBean);

	}//End of addProduct()

	@Override
	public boolean updateProduct(ProductBean productBean) {

		return dao.updateProduct(productBean);
	}

	@Override
	public boolean deleteProduct(int pId) {
		return dao.deleteProduct(pId);
	}

	@Override
	public List<ProductBean> getAllProduct() {
		return dao.getAllProduct();
	}

	
}//End of Implimentation()
