package com.capgemini.medicalshopcollection.database;

import java.util.HashMap;

import com.capgemini.medicalshopcollection.beans.ProductBean;


public class ProductTable {
	public static HashMap<Integer, ProductBean> productDb = new HashMap<>();
	
	public ProductTable() {
		ProductBean productBean1 = new ProductBean();
		productBean1.setProductId(101);
		productBean1.setProductName("Myaxyl Capsules");
		productBean1.setProductBrand("Kerala Ayurveda");
		productBean1.setCategory("Ayurvedic");
		productBean1.setPrice(150.00);
		productBean1.setDetails("It used to reduces degradation of Glycosaminoglycan.");
		productBean1.setAvailable("In Stock");
		productBean1.setQuantity(20);
		productDb.put(productBean1.getProductId(), productBean1);
		
		
		ProductBean productBean2 = new ProductBean();
		productBean2.setProductId(102);
		productBean2.setProductName("Kudos IME9");
		productBean2.setProductBrand("Kudos Pharmaceuticals");
		productBean2.setCategory("Ayurvedic");
		productBean2.setPrice(80.00);
		productBean2.setDetails("It used for Diabetes");
		productBean2.setAvailable("In Stock");
		productBean2.setQuantity(10);
		productDb.put(productBean2.getProductId(), productBean2);
		
		ProductBean productBean3 = new ProductBean();
		productBean3.setProductId(103);
		productBean3.setProductName("Baby Soap");
		productBean3.setProductBrand("Johnson");
		productBean3.setCategory("Baby Care");
		productBean3.setPrice(50.00);
		productBean3.setDetails("Very soft soap for babies.");
		productBean3.setAvailable("In Stock");
		productBean3.setQuantity(30);
		productDb.put(productBean3.getProductId(), productBean3);
		
		ProductBean productBean4 = new ProductBean();
		productBean4.setProductId(104);
		productBean4.setProductName("Huggies Diapers");
		productBean4.setProductBrand("Huggies");
		productBean4.setCategory("Baby Care");
		productBean4.setPrice(110.00);
		productBean4.setDetails("Inside layer of the diaper is super fluffy and provides cotton ");
		productBean4.setAvailable("In Stock");
		productBean4.setQuantity(25);
		productDb.put(productBean4.getProductId(), productBean4);
		
		
	}//End of productTable() constructor
}
