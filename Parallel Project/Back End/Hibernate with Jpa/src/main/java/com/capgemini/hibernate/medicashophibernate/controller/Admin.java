package com.capgemini.hibernate.medicashophibernate.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.hibernate.medicashophibernate.beans.MessageBean;
import com.capgemini.hibernate.medicashophibernate.beans.ProductBean;
import com.capgemini.hibernate.medicashophibernate.beans.UserBean;
import com.capgemini.hibernate.medicashophibernate.dao.MessageDao;
import com.capgemini.hibernate.medicashophibernate.dao.ProductDao;
import com.capgemini.hibernate.medicashophibernate.dao.medicalShopDAO;
import com.capgemini.hibernate.medicashophibernate.factory.MessageFactory;
import com.capgemini.hibernate.medicashophibernate.factory.ProductFactory;
import com.capgemini.hibernate.medicashophibernate.factory.medicalShopFactory;


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

			boolean add = productDao.addProduct(pId, name, category, price);
				if(add==true) {
					System.out.println("Product Added");
				}else {
					System.out.println("Product Not Added");
				}
		} else if (adminButton == 2) {
			System.out.println("Enter Product Id where you want to update");
			int pId = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Product Name");
			String name=sc.nextLine();
			System.out.println("Enter Product Category");
			String category=sc.nextLine();
			System.out.println("Enter price");
			double price=Integer.parseInt(sc.nextLine());
			
			boolean update = productDao.updateProduct(pId,name,category,price);
			if(update==true) {
				System.out.println("Product updated");
			}else {
				System.out.println("Product Not updated");
			}

		} else if (adminButton == 3) {
			System.out.println("Enter Product Id where you want to delete");
			int pId = Integer.parseInt(sc.nextLine());
			boolean delete = productDao.deleteProduct(pId);
			if(delete==true) {
				System.out.println("Product Deleted");
			}else {
				System.out.println("Product Not Deleted");
			}

		} else if (adminButton == 4) {
			List<ProductBean> allProduct = productDao.getAllProduct();
			System.out.println("------Products List------");
			for (ProductBean bean : allProduct) {
				System.out.println("*********************");
				System.out.println("Product Id is "+bean.getProductId());
				System.out.println("Product name is "+bean.getProductName());
				System.out.println("Product category is "+bean.getCategory());
				System.out.println("Product price is "+bean.getPrice());
				System.out.println("*********************");
			}

		} else if (adminButton == 5) {
			List<UserBean> userBean = dao.getAllUser();
			for (UserBean bean : userBean) {
				System.out.println("*********************");
				System.out.println("User Id is "+bean.getUserId());
				System.out.println("User Name is "+bean.getUserName());
				System.out.println("User Password is "+bean.getUserPassword());
				System.out.println("User Email is "+bean.getUserEmail());
				System.out.println("*********************");
			}
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
			List<MessageBean> messageBean = messageDao.getMessage();
			for (MessageBean bean : messageBean) {
				System.out.println("*****************");
				System.out.println("User Id is "+bean.getUserId());
				System.out.println("Message is "+bean.getMessage());
				System.out.println("*****************");
			}
			System.out.println("select userId whom you want to send reply");
			int uId = Integer.parseInt(sc.nextLine());
			if (uId != 0) {
				String type = "Answer";
				System.out.println("Enter reply");
				String message = sc.nextLine();
				boolean mb = messageDao.sendResponse(message, type, uId);
				System.out.println("Replied");
			}
		}else if (adminButton==0) {
			System.out.println("Logged Out");
			System.exit(0);
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
