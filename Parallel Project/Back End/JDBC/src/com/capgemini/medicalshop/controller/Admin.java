package com.capgemini.medicalshop.controller;

import java.util.Scanner;

import com.capgemini.medicalshop.bean.MessageBean;
import com.capgemini.medicalshop.bean.ProductBean;
import com.capgemini.medicalshop.bean.UserBean;
import com.capgemini.medicalshop.dao.MessageDao;
import com.capgemini.medicalshop.dao.ProductDao;
import com.capgemini.medicalshop.dao.medicalShopDAO;
import com.capgemini.medicalshop.factory.MessageFactory;
import com.capgemini.medicalshop.factory.ProductFactory;
import com.capgemini.medicalshop.factory.medicalShopFactory;

public class Admin {

	Scanner sc = new Scanner(System.in);
	medicalShopDAO dao = medicalShopFactory.getInstance();
	ProductDao productDao = ProductFactory.getProductInstance();
	MessageDao messageDao = MessageFactory.getMessageInstance();

	public void adminTest() {
		System.out.println("press 1 to Add Product");
		System.out.println("press 2 to Update Product");
		System.out.println("press 3 to Delete Product");
		System.out.println("press 4 to  see all product");
		System.out.println("press 5 to see user list");
		System.out.println("press 6 to see users messages");
		System.out.println("press 0 to Logout");
		int adminButton = Integer.parseInt(sc.nextLine());

		if (adminButton == 1) {
			System.out.println("Enter Product Id ");
			int pId = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Product Name ");
			String name = sc.nextLine();
			System.out.println("Enter Product Category ");
			String category = sc.nextLine();
			System.out.println("Enter Product price ");
			Double price = Double.parseDouble(sc.nextLine());

			ProductBean productBean1 = productDao.addProduct(pId, name, category, price);

		} else if (adminButton == 2) {
			System.out.println("Enter Product Id where you want to update");
			int pId = Integer.parseInt(sc.nextLine());
			ProductBean productBean2 = productDao.updateProduct(pId);

		} else if (adminButton == 3) {
			System.out.println("Enter Product Id where you want to delete");
			int pId = Integer.parseInt(sc.nextLine());
			ProductBean productBean3 = productDao.deleteProduct(pId);

		} else if (adminButton == 4) {
			ProductBean productBean4 = productDao.getAllProduct();

		} else if (adminButton == 5) {
			UserBean userBean = dao.getAllUser();
			System.out.println("Do you want to delete any user");
			System.out.println("enter 'y' to Yes");
			System.out.println("enter 'n' to No");
			String button = sc.nextLine();
			if (button.equalsIgnoreCase("y")) {
				System.out.println("Enter UserId to be deleted");
				int id = sc.nextInt();
				sc.nextLine();
				boolean delete = dao.removeUser(id);
				System.out.println("User Deleted Successfully.....");
			} else if (button.equalsIgnoreCase("n")) {
				adminTest();
			}
		} else if (adminButton == 6) {
			MessageBean messageBean = messageDao.getMessage();
			System.out.println("select userId whom you want to send reply");
			int uId = Integer.parseInt(sc.nextLine());
			if (uId != 0) {
				String type = "Answer";
				System.out.println("Enter reply");
				String message = sc.nextLine();
				MessageBean mb = messageDao.sendResponse(message, type, uId);
				System.out.println("Replied");
			}
		}else if (adminButton==0) {
			System.exit(0);
			System.out.println("Logged Out");
		}

		System.out.println("enter 'y' to continue as Admin");
		System.out.println("enter 'n' to logout");
		String button = sc.nextLine();
		if (button.equalsIgnoreCase("y")) {
			adminTest();
		} else if (button.equalsIgnoreCase("n")) {
			System.exit(0);
		}
	}

}// End of AdminTest()
