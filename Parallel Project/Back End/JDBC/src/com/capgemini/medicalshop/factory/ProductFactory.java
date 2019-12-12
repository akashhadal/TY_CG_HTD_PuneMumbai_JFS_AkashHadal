package com.capgemini.medicalshop.factory;

import com.capgemini.medicalshop.dao.ProductDao;
import com.capgemini.medicalshop.dao.ProductImpl;

public class ProductFactory {
	
	
	private ProductFactory() {
		
	}// end of constructor
	
	public static ProductDao getProductInstance() {
		ProductDao productDao  = new ProductImpl();
		return productDao;
	}//end of getProductInstance

}// end of class
