package com.capgemini.medicalshop.controller;

import java.util.Scanner;

import com.capgemini.medicalshop.bean.CartBean;
import com.capgemini.medicalshop.dao.CartDao;
import com.capgemini.medicalshop.factory.CartFactory;

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
			CartBean cartBean = cartDao.addProduct(uId);
		} else if (cartButton == 2) {
			System.out.println("enter product name to delete");
			String pName = sc.nextLine();
			CartBean cartBean = cartDao.deleteProduct(pName);

		} else if (cartButton == 3) {
			System.out.println("Enter address");
			String address=sc.nextLine();
			CartBean cartBean = cartDao.payment(uId,address);
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
