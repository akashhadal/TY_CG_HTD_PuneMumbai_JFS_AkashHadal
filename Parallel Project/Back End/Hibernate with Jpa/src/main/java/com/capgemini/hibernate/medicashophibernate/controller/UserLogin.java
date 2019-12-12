package com.capgemini.hibernate.medicashophibernate.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.hibernate.medicashophibernate.beans.ProductBean;
import com.capgemini.hibernate.medicashophibernate.beans.UserBean;
import com.capgemini.hibernate.medicashophibernate.dao.ProductDao;
import com.capgemini.hibernate.medicashophibernate.dao.medicalShopDAO;
import com.capgemini.hibernate.medicashophibernate.factory.ProductFactory;
import com.capgemini.hibernate.medicashophibernate.factory.medicalShopFactory;


public class UserLogin {

	public void user() {
		Scanner sc = new Scanner(System.in);

		medicalShopDAO medicalShopDAO = medicalShopFactory.getInstance();
		ProductDao productDao = ProductFactory.getProductInstance();

		System.out.println("press 1 to See Product");
		System.out.println("press 2 to Login");
		System.out.println("press 3 to Register");

		int userButton = Integer.parseInt(sc.nextLine());

		if (userButton == 1) {

			List<ProductBean> productBean = productDao.getAllProduct();
			for (ProductBean bean : productBean) {
				System.out.println("*********************");
				System.out.println("Product Id is "+bean.getProductId());
				System.out.println("Product name is "+bean.getProductName());
				System.out.println("Product category is "+bean.getCategory());
				System.out.println("Product price is "+bean.getPrice());
				System.out.println("*********************");
			}
		} else if (userButton == 2) {

			System.out.println("Enter User Name");
			String name = sc.nextLine();

			System.out.println("Enter User Password");
			String password = sc.nextLine();

			UserBean userBean2 = medicalShopDAO.loginUser(name, password);

			
			if (userBean2!=null) {
				User userTest=new User();
				userTest.userTest(userBean2.getUserId());
				
			}
		} else if (userButton == 3) {
			System.out.println("Enter User Id");
			int userId = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter User Name");
			String userName = sc.nextLine();

			System.out.println("Enter User Password");
			String userPassword = sc.nextLine();

			System.out.println("Enter User email");
			String userEmail = sc.nextLine();

			UserBean bean = medicalShopDAO.registerUser(userId, userName, userEmail, userPassword);

		}
		System.out.println("enter 'y' to continue");
		System.out.println("enter 'n' to logout");
		String button = sc.nextLine();
		if (button.equalsIgnoreCase("y")) {
			user();
		} else if (button.equalsIgnoreCase("n")) {
			System.out.println("successfully logout");
			return;
		}
	}// End of User
}// End of class
