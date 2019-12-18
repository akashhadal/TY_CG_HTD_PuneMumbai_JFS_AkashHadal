package com.capgemini.medicalshopcollection.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicalshopcollection.beans.ProductBean;
import com.capgemini.medicalshopcollection.exception.ExceptionsMethods;
import com.capgemini.medicalshopcollection.exception.OMSException;
import com.capgemini.medicalshopcollection.service.MedicalServices;
import com.capgemini.medicalshopcollection.service.MedicalservicesImpl;
import com.capgemini.medicalshopcollection.service.ProductServices;
import com.capgemini.medicalshopcollection.service.ProductServicesImpl;


public class ProductsTest {
	Scanner scanner = new Scanner(System.in);
	static MedicalServices medicalServices = new MedicalservicesImpl();
	static ProductServices productServices = new ProductServicesImpl();
	static ExceptionsMethods exceptionsMethods = new ExceptionsMethods();
	static ProductBean productBean = new ProductBean();

	public void addProducts() {
		ProductBean productBean = new ProductBean();
		System.out.println("Enter the Product Id: ");
		String productId1 = scanner.next();
		int productId = 0;
		try {
			productId = ExceptionsMethods.numberValidation(productId1);
		} catch (OMSException e1) {
			e1.getMessage();
		}
		
		scanner.nextLine();
		boolean isPresent = productServices.searchProduct(productId);
		if (isPresent == false) {
			productBean.setProductId(productId);
			System.out.println("Enter Product Name: ");
			productBean.setProductName(scanner.nextLine());
			System.out.println("Enter Product Brand: ");
			productBean.setProductBrand(scanner.nextLine());
			System.out.println("Enter Product Category: ");
			productBean.setCategory(scanner.nextLine());
			System.out.println("Enter Product Price: ");
			productBean.setPrice(scanner.nextDouble());
			scanner.nextLine();
			System.out.println("Enter Product Details: ");
			productBean.setDetails(scanner.nextLine());
			System.out.println("Enter Product Available or not");
			productBean.setAvailable(scanner.nextLine());
			boolean addState = productServices.addProduct(productBean);

			if (addState == true) {
				System.out.println("New Product Added Successfully!!!");
			} else {
				System.err.println("Unable To Add Product");
			}
		} else {
			System.err.println("Product With Same Product Id Does Already Exist!!!");
			addProducts();
		}
	}// End of addProducts()
	
	public void updateProducts() {
		System.out.println("Enter the Product Id you want to update : ");
		String productId1 = scanner.next();
		int productId = 0;
		try {
			productId = ExceptionsMethods.numberValidation(productId1);
		} catch (OMSException e1) {
			e1.getMessage();
		}
		
		boolean isPresent = productServices.searchProduct(productId);
		if (isPresent == true) {
			productBean.setProductId(productId);
			System.out.println("Enter the new price for this Item");
			double price = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Enter Currently Product is InStock or Not InStock");
			String available = scanner.nextLine(); 
			
			boolean updated = productServices.updateProduct(productId, price, available);
			if(updated) {
				System.out.println("Successfully Updated Product Info");
				System.out.println("-----------------------------------------------------------------");
				
			} else {
				System.out.println("Unable To Update");
				updateProducts();
			}
		
		} else {
			System.err.println("Product With This Id Does Not Exists");
			updateProducts();
		}
		
		
	}//End of updateProducts()
	
	public void deleteProduct() {
		System.out.println("Enter the Product Id you  want to delete : ");
		String productId1 = scanner.next();
		int productId = 0;
		try {
			productId = ExceptionsMethods.numberValidation(productId1);
		} catch (OMSException e) {
			e.getMessage();
		}
		
		boolean isPresent = productServices.searchProduct(productId);
		if (isPresent == true) {
			if(productServices.removeProduct(productId)) {
				System.out.println("Product Remove Successfully");
			} else {
				System.err.println("Unable To Remove Product");
				deleteProduct();
			}
			
		} else {
			System.err.println("Product With This Id Does Not Exists");
		}
	}//End of deleteProduct()
	
	public void showProducts() {
		List<ProductBean> productList = null;
			productList = productServices.getAllProducts();
			for (ProductBean productBean1 : productList) {
				System.out.println("---------------------------------------------------------");
				System.out.println("Product ID = " + productBean1.getProductId());
				System.out.println("Product Name = " + productBean1.getProductName());
				System.out.println("Product Brand = " + productBean1.getProductBrand());
				System.out.println("Category = " + productBean1.getCategory());
				System.out.println("Price = " + productBean1.getPrice());
				System.out.println("Details = " + productBean1.getDetails());
				System.out.println("Available = " + productBean1.getAvailable());
				System.out.println("---------------------------------------------------------");

		} 
	}//End of showProducts()
}// End of Class
