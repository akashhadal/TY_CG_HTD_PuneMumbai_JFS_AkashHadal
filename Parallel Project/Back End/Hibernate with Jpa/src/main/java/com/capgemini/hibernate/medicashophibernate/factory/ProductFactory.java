package com.capgemini.hibernate.medicashophibernate.factory;

import com.capgemini.hibernate.medicashophibernate.dao.ProductDao;
import com.capgemini.hibernate.medicashophibernate.dao.ProductImpl;

public class ProductFactory {
	
	
	private ProductFactory() {
		
	}// end of constructor
	
	public static ProductDao getProductInstance() {
		ProductDao productDao  = new ProductImpl();
		return productDao;
	}//end of getProductInstance

}// end of class
