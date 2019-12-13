package com.capgemini.medicalshopcollection.database;

import java.util.HashMap;

import com.capgemini.medicalshopcollection.beans.ProductBean;


public class Product {
	public static HashMap<Integer, ProductBean> product = new HashMap<>();
	
	public Product() {
		ProductBean productBean1 = new ProductBean();
		productBean1.setProductId(101);
		productBean1.setProductName("Crosin");
		productBean1.setProductBrand("Panadol");
		productBean1.setCategory("analgesic");
		productBean1.setPrice(150.00);
		productBean1.setDetails("pain management and relief");
		productBean1.setAvailable("In Stock");
		productBean1.setQuantity(20);
		product.put(productBean1.getProductId(), productBean1);
		
		
		ProductBean productBean2 = new ProductBean();
		productBean2.setProductId(102);
		productBean2.setProductName("paracetamol ");
		productBean2.setProductBrand("Tylenol");
		productBean2.setCategory("acetaminophen");
		productBean2.setPrice(80.00);
		productBean2.setDetails("It used for Diabetes");
		productBean2.setAvailable("In Stock");
		productBean2.setQuantity(10);
		product.put(productBean2.getProductId(), productBean2);
		
		ProductBean productBean3 = new ProductBean();
		productBean3.setProductId(103);
		productBean3.setProductName("Baby Soap");
		productBean3.setProductBrand("Johnson");
		productBean3.setCategory("Baby Care");
		productBean3.setPrice(50.00);
		productBean3.setDetails("Very soft soap for babies.");
		productBean3.setAvailable("In Stock");
		productBean3.setQuantity(30);
		product.put(productBean3.getProductId(), productBean3);
		
		
	}//End of productTable() constructor
}
