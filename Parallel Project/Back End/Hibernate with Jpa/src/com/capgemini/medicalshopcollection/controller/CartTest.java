package com.capgemini.medicalshopcollection.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicalshopcollection.beans.CartBean;
import com.capgemini.medicalshopcollection.beans.UserBean;
import com.capgemini.medicalshopcollection.service.CartServices;
import com.capgemini.medicalshopcollection.service.CartServicesImpl;


public class CartTest {
	Scanner scanner = new Scanner(System.in);
	static CartServices cartServices = new CartServicesImpl();

	public void cartOperation(UserBean userBean) {
		while (true) {
			System.out.println("Enter 1 to add Product to Cart\nEnter 2 to remove Product from Cart\nEnter 3 to show all products in cart\nEnter 4 to show Total Bill\nEnter 5 For Payment\nEnter 6 to go back to menu");
			int operation = scanner.nextInt();
			switch (operation) {
			case 1:// Add product into cart
				new AddProductIntoCart().addProductIntoCart(userBean);
				break;

			case 2:// Remove product from cart
				break;

			case 3:// Show all cart Products
				List<CartBean> cartBean = cartServices.getAllProducts();
				for (CartBean cartList : cartBean) {
					System.out.println("--------------------------------------------------");
					System.out.println("Cart ID = " +cartList.getCartId());
					System.out.println("User ID = " +cartList.getUserId());
					System.out.println("User Name = " +cartList.getUserName());
					System.out.println("Product ID = "+cartList.getProductId());
					System.out.println("Product Name = "+cartList.getProductName());
					System.out.println("Price = "+cartList.getPrice());
					System.out.println("Quantity = "+cartList.getQuantity());
					System.out.println("--------------------------------------------------");
				}
				break;

			case 4:// total bill
				System.out.println("Total Bill is = "+cartServices.totalBill(userBean.getUserId()));
				
				break;

			case 5:// Payment
				new Payment().payment(userBean);
				break;

			case 6:// back menu
				new UserTest().userLogin(userBean);
				break;

			default:
				System.err.println("Enter Valid Option");
				break;
			}// End of switch()
		}
	}// End of cartOperation()

}// End of Class
