package com.capgemini.medicalshop.controller;

import java.util.Scanner;

import com.capgemini.medicalshop.bean.ProductBean;
import com.capgemini.medicalshop.bean.UserBean;
import com.capgemini.medicalshop.dao.ProductDao;
import com.capgemini.medicalshop.dao.medicalShopDAO;
import com.capgemini.medicalshop.factory.ProductFactory;
import com.capgemini.medicalshop.factory.medicalShopFactory;

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

			ProductBean productBean = productDao.getAllProduct();
		} else if (userButton == 2) {

			System.out.println("Enter User Name");
			String name = sc.nextLine();

			System.out.println("Enter User Password");
			String password = sc.nextLine();

			int userBean2 = medicalShopDAO.loginUser(name, password);

			int getUserId = userBean2;
			if (getUserId > 0) {
				User userTest=new User();
				userTest.userTest(getUserId);
				
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
