package com.capgemini.hibernate.medicashophibernate.controller;

import java.util.Scanner;

import com.capgemini.hibernate.medicashophibernate.beans.CartBean;
import com.capgemini.hibernate.medicashophibernate.dao.CartDao;
import com.capgemini.hibernate.medicashophibernate.factory.CartFactory;


public class CartTest {

	public static void cart(int getUId) {
		Scanner sc = new Scanner(System.in);
		CartDao cartDao = CartFactory.getCartInstance();

		System.out.println("press 1 to add product into cart");
		System.out.println("press 2 to delete product from cart");
		System.out.println("press 3 to do payment");

		int cartButton = Integer.parseInt(sc.nextLine());
		int uId = getUId;
		if (cartButton == 1) {
			boolean cartBean = cartDao.addProduct(uId);
			if (cartBean) {
				System.out.println("Product added to cart");
			} else {
				System.out.println("Cart Failed");
			}
		} else if (cartButton == 2) {
			System.out.println("enter product name to delete");
			String pName = sc.nextLine();
			boolean cartBean = cartDao.deleteProduct(pName,uId);

		} else if (cartButton == 3) {
			double cartBean = cartDao.payment(uId);
			
		}

		System.out.println("enter 'y' to continue Shopping");
		System.out.println("enter 'n' to logout");
		String button = sc.nextLine();
		if (button.equalsIgnoreCase("y")) {
			cart(getUId);
		} else if (button.equalsIgnoreCase("n")) {
			System.out.println("successfully logout");
			return;
		}

	}// end of cart()

}// end of class
