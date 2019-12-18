package com.capgemini.medicalshopcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalshopcollection.beans.CartBean;
import com.capgemini.medicalshopcollection.beans.ProductBean;
import com.capgemini.medicalshopcollection.beans.UserBean;
import com.capgemini.medicalshopcollection.service.CartServices;
import com.capgemini.medicalshopcollection.service.CartServicesImpl;
import com.capgemini.medicalshopcollection.service.ProductServices;
import com.capgemini.medicalshopcollection.service.ProductServicesImpl;


public class AddProductIntoCart {
	Scanner scanner = new Scanner(System.in);
	static ProductServices productServices = new ProductServicesImpl();
	static CartServices cartServices = new CartServicesImpl();
	
	public void addProductIntoCart(UserBean userBean) {
		CartBean cartBean = new CartBean();
		int userId = userBean.getUserId();
		System.out.println(userId);
		String userName = userBean.getUserName();
		System.out.println("Enter Order Number");
		int cartId = scanner.nextInt();
		System.out.println("Enter Product ID which you want to order: ");
		int productId = scanner.nextInt();
		if (productServices.searchProduct(productId)) {
			ProductBean productBean = productServices.getProduct(productId);
			String productName = productBean.getProductName();
			double price = productBean.getPrice();
			System.out.println("Available Quantity are: "+productBean.getQuantity());
			System.out.println("Enter Number Of Quantity You Want to order: ");
			int setQuantity = scanner.nextInt();
			
			//Single product price * number of required quantity
			double orderProductPrice = price * setQuantity;
			System.out.println("Calculated Price Is = "+orderProductPrice);
			//checking if present quantity greater than required quantity
			if (setQuantity <= productBean.getQuantity()) {
				cartBean.setCartId(cartId);
				cartBean.setUserId(userId);
				cartBean.setUserName(userName);
				cartBean.setProductId(productId);
				cartBean.setProductName(productName);
				cartBean.setPrice(orderProductPrice);
				cartBean.setQuantity(setQuantity);
				boolean state = cartServices.addIntoCart(cartBean);
				if(state) {
					System.out.println("Added To Cart");
					double bill = cartServices.totalBill(userId);
					System.out.println("Total Bill is = "+bill);
				} else {
					System.out.println("Unable To Add Into Cart");
					addProductIntoCart(userBean);
				}
			}
			
			
		} else {
			System.err.println("Product with this id does not exists");
		}
		
		
		
		
	}//End of addProductIntoCart()

}//End of Class
