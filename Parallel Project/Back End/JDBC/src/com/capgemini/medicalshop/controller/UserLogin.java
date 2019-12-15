package com.capgemini.medicalshop.controller;

import java.util.Scanner;

import com.capgemini.medicalshop.bean.ProductBean;
import com.capgemini.medicalshop.bean.UserBean;
import com.capgemini.medicalshop.dao.ProductDao;
import com.capgemini.medicalshop.dao.medicalShopDAO;
import com.capgemini.medicalshop.exception.ExceptionsMethods;
import com.capgemini.medicalshop.exception.OMSException;
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
		
		String choice=sc.nextLine();
		int userButton=0;
		try {
			userButton = ExceptionsMethods.numberValidation(choice);
		} catch (OMSException e) {
			e.getMessage();
			user();
		}

		if (userButton == 1) {

			ProductBean productBean = productDao.getAllProduct();
		} else if (userButton == 2) {

			System.out.println("Enter User Name");
			String name = sc.nextLine();

			System.out.println("Enter User Password");
			String choicePassword = sc.nextLine();
			String password=null;
			try {
				 password=ExceptionsMethods.checkPassword(choicePassword);
			} catch (OMSException e) {
				e.getMessage();
				user();
			};

			int userBean2 = medicalShopDAO.loginUser(name, password);

			int getUserId = userBean2;
			if (getUserId > 0) {
				User userTest=new User();
				userTest.userTest(getUserId);
				
			}
		} else if (userButton == 3) {
			System.out.println("Enter User Id");
			int userId = 0;
			String uId = sc.nextLine();
			try {
				 userId=ExceptionsMethods.numberValidation(uId);
			} catch (OMSException e) {
				e.getMessage();
				user();
			};
			System.out.println("Enter User Name");
			String userName = sc.nextLine();

			System.out.println("Enter User Password");
			//String userPassword = sc.nextLine();
			String choicePassword = sc.nextLine();
			String userPassword=null;
			try {
				 userPassword=ExceptionsMethods.checkPassword(choicePassword);
			} catch (OMSException e) {
				e.getMessage();
				user();
			};
			
			System.out.println("Enter User email");
			String userEmail = null;
			String choiceEmail = sc.nextLine();
			try {
				 userEmail=ExceptionsMethods.checkPassword(choiceEmail);
			} catch (OMSException e) {
				e.getMessage();
				user();
			};

			UserBean bean = medicalShopDAO.registerUser(userId, userName, userEmail, userPassword);
		}
		System.out.println("enter 'y' to continue");
		System.out.println("enter 'n' to logout");
		String choiceUser = sc.nextLine();
		String button=null;
		try {
			button=ExceptionsMethods.charValidation(choiceUser);
		} catch (Exception e) {
			e.getMessage();
			user();
		}
		if (button.equalsIgnoreCase("y")) {
			user();
		} else if (button.equalsIgnoreCase("n")) {
			System.out.println("successfully logout");
			System.exit(0);
		}
	}// End of User
}// End of class
