package com.capgemini.medicalshop.controller;

import java.util.Scanner;

import com.capgemini.medicalshop.bean.MessageBean;
import com.capgemini.medicalshop.bean.ProductBean;
import com.capgemini.medicalshop.bean.UserBean;
import com.capgemini.medicalshop.dao.CartDao;
import com.capgemini.medicalshop.dao.MessageDao;
import com.capgemini.medicalshop.dao.ProductDao;
import com.capgemini.medicalshop.dao.MedicalShopDAO;
import com.capgemini.medicalshop.exception.ExceptionsMethods;
import com.capgemini.medicalshop.exception.OMSException;
import com.capgemini.medicalshop.factory.CartFactory;
import com.capgemini.medicalshop.factory.MessageFactory;
import com.capgemini.medicalshop.factory.ProductFactory;
import com.capgemini.medicalshop.factory.MedicalShopFactory;

public class User {

	Scanner sc = new Scanner(System.in);

	MedicalShopDAO medicalShopDAO = MedicalShopFactory.getInstance();
	ProductDao productDao = ProductFactory.getProductInstance();
	MessageDao messageDao = MessageFactory.getMessageInstance();
	CartDao cartDao = CartFactory.getCartInstance();

	public void userTest(int getUid) {

		System.out.println("Press 1 to see product list");
		System.out.println("Press 2 to place order");
		System.out.println("press 3 to see profile");
		System.out.println("Press 4 to see order History ");
		System.out.println("press 5 to see discussion board");
		System.out.println("Press 6 to logout");

		int userLoginButton = 0;
		String choice=sc.nextLine();
		try {
			userLoginButton = ExceptionsMethods.numberValidation(choice);
		} catch (OMSException e) {
			e.getMessage();
			userTest(getUid);
		}

		
		if (userLoginButton == 1) {
			ProductBean productBean = productDao.getAllProduct();

		} else if (userLoginButton == 2) {
			CartTest cartTest = new CartTest();
			cartTest.cart(getUid);

		} else if (userLoginButton == 3) {

			UserBean userBeanall = medicalShopDAO.getAllUser();

			System.out.println("press 1 to update");
			System.out.println("Press 0 to bo back");
			int button = 0;
			String choiceProfile=sc.nextLine();
			try {
				button = ExceptionsMethods.numberValidation(choiceProfile);
			} catch (OMSException e) {
				e.getMessage();
				userTest(getUid);
			}
			if (button == 1) {

				UserBean userBeanl = medicalShopDAO.updateUserProfile(getUid);
			} else if (button == 0) {
				userTest(getUid);
			}

		} else if (userLoginButton == 4) {
			cartDao.list(getUid);
		}

		else if (userLoginButton == 5) {
			System.out.println("enter 1 to write query");
			System.out.println("enter 2 to see response");
			int button = 0;
			String choiceDiscussion=sc.nextLine();
			try {
				userLoginButton = ExceptionsMethods.numberValidation(choiceDiscussion);
			} catch (OMSException e) {
				e.getMessage();
				userTest(getUid);
			}
			if (button == 1) {
				String type = "Question";
				System.out.println("Enter Your Query");
				String message = sc.nextLine();
				MessageBean messageBean = messageDao.sendMessage(message, type, getUid);
			} else if (button == 2) {
				MessageBean messageBean2 = messageDao.getResponse(getUid);
			}
		} else if (userLoginButton == 6) {
			System.exit(0);

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
