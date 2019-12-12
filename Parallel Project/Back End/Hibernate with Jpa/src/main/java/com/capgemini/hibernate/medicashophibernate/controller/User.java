package com.capgemini.hibernate.medicashophibernate.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.hibernate.medicashophibernate.beans.MessageBean;
import com.capgemini.hibernate.medicashophibernate.beans.OrderBean;
import com.capgemini.hibernate.medicashophibernate.beans.ProductBean;
import com.capgemini.hibernate.medicashophibernate.beans.UserBean;
import com.capgemini.hibernate.medicashophibernate.dao.CartDao;
import com.capgemini.hibernate.medicashophibernate.dao.MessageDao;
import com.capgemini.hibernate.medicashophibernate.dao.ProductDao;
import com.capgemini.hibernate.medicashophibernate.dao.medicalShopDAO;
import com.capgemini.hibernate.medicashophibernate.factory.CartFactory;
import com.capgemini.hibernate.medicashophibernate.factory.MessageFactory;
import com.capgemini.hibernate.medicashophibernate.factory.ProductFactory;
import com.capgemini.hibernate.medicashophibernate.factory.medicalShopFactory;

public class User {

	Scanner sc = new Scanner(System.in);

	medicalShopDAO medicalShopDAO = medicalShopFactory.getInstance();
	ProductDao productDao = ProductFactory.getProductInstance();
	MessageDao messageDao = MessageFactory.getMessageInstance();
	CartDao cartDao=CartFactory.getCartInstance();
	
	public void userTest(int getUid) {

		System.out.println("Press 1 to see product list");
		System.out.println("Press 2 to place order");
		System.out.println("press 3 to see profile");
		System.out.println("press 4 to see discussion board");
		System.out.println("press  5 to display Order History");
		System.out.println("Press 6 to logout");

		int userLoginButton = Integer.parseInt(sc.nextLine());

		if (userLoginButton == 1) {
			List<ProductBean> pBean = productDao.getAllProduct();
			for (ProductBean bean : pBean) {
				System.out.println("*********************");
				System.out.println("Product Id is " + bean.getProductId());
				System.out.println("Product name is " + bean.getProductName());
				System.out.println("Product category is " + bean.getCategory());
				System.out.println("Product price is " + bean.getPrice());
				System.out.println("*********************");
			}

		} else if (userLoginButton == 2) {
			CartTest cartTest = new CartTest();
			cartTest.cart(getUid);

		} else if (userLoginButton == 3) {

			UserBean bean = medicalShopDAO.getUser(getUid);
			System.out.println("*********************");
			System.out.println("User Id is " + bean.getUserId());
			System.out.println("User Name is " + bean.getUserName());
			System.out.println("User Password is " + bean.getUserPassword());
			System.out.println("User Email is " + bean.getUserEmail());
			System.out.println("*********************");
			System.out.println("press 1 to update");
			System.out.println("Press 0 to bo back");
			int button = Integer.parseInt(sc.nextLine());

			if (button == 1) {
				System.out.println("Enter User Id where you want to update");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Enter User Name");
				String name = sc.nextLine();
				System.out.println("Enter User Email");
				String email = sc.nextLine();
				System.out.println("Enter User Password");
				String password = sc.nextLine();
				UserBean userBeanl = medicalShopDAO.updateUserProfile(id, name, email, password);
			} else if (button == 0) {
				userTest(getUid);
			}

		} else if (userLoginButton == 4) {
			System.out.println("enter 1 to write query");
			System.out.println("enter 2 to see response");
			int button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				String type = "Question";
				System.out.println("Enter Your Query");
				String message = sc.nextLine();
				if (messageDao.sendMessage(message, type, getUid)) {
					System.out.println("Query Sent");
				} else {
					System.out.println("Query Not Sent");
				}
			} else if (button == 2) {
				List<MessageBean> messageBean2 = messageDao.getResponse(getUid);
				List<MessageBean> messageQuery = messageDao.getMessage();
					for (MessageBean messageBean : messageBean2) {
						System.out.println("*********************");
						System.out.println("type ::" + messageBean.getType());
						System.out.println("Response ::" + messageBean.getMessage());
						System.out.println("*********************");
					}
				}
		} else if (userLoginButton == 6) {
			System.exit(0);

		}else if (userLoginButton==5) {
			List<OrderBean> beans=cartDao.orderBeans(getUid);
			for (OrderBean bean : beans) {
				System.out.println("*********************");
				/*
				 * System.out.println("User Id is " + bean.getUserId());
				 * System.out.println("User name is " + bean.getUserName());
				 */
				System.out.println("Product Id is " + bean.getProductId());
				System.out.println("Product name is " + bean.getProductName());
				System.out.println("Address is " + bean.getAddress());
				System.out.println("Product price is " + bean.getPrice());
				System.out.println("*********************");
			}
		}
		System.out.println("enter 'y' to continue as User");
		System.out.println("enter 'n' to logout");
		String button = sc.nextLine();
		if (button.equalsIgnoreCase("y")) {
			userTest(getUid);
		} else if (button.equalsIgnoreCase("n")) {
			System.exit(0);
		}

	}// End of UserTest()

}// End of class
