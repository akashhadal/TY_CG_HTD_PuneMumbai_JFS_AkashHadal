package com.capgemini.medicalshop.controller;

import java.util.Scanner;

import com.capgemini.medicalshop.dao.medicalShopDAO;
import com.capgemini.medicalshop.exception.ExceptionsMethods;
import com.capgemini.medicalshop.exception.OMSException;
import com.capgemini.medicalshop.factory.medicalShopFactory;

public class AdminLogin {

	public void aLogin() {
		Scanner sc = new Scanner(System.in);
		medicalShopDAO dao = medicalShopFactory.getInstance();

		System.out.println("Press 1 to Login\nPress 2 to Register");
		String choice = sc.nextLine();
		int adminButton = 0;
		try {
			adminButton = ExceptionsMethods.numberValidation(choice);
		} catch (OMSException e) {
			e.getMessage();
			aLogin();
		}

		if (adminButton == 1) {
			System.out.println("Enter Email");
			String choiceEmail = sc.nextLine();
			String adminEmail = null;
			try {
				adminEmail = ExceptionsMethods.emailValidator(choiceEmail);
			} catch (OMSException e) {
				e.getMessage();
				aLogin();
			}

			System.out.println("Enter Password");
			String choicePassword = sc.nextLine();
			String adminPassword = null;
			try {
				adminPassword = ExceptionsMethods.checkPassword(choicePassword);
			} catch (OMSException e) {
				e.getMessage();
				aLogin();
			}

			int admin = dao.loginAdmin(adminEmail, adminPassword);

			int getUserId = admin;
			if (getUserId > 0) {
				Admin at = new Admin();
				at.adminTest();

			} else {
				System.out.println("Admin Login Failed");
			}
		} else if (adminButton == 2) {
			System.out.println("Enter Admin Id");
			int userId = 0;
			String uId = sc.nextLine();
			try {
				userId = ExceptionsMethods.numberValidation(uId);
			} catch (OMSException e) {
				e.getMessage();
				aLogin();
			}
			;
			System.out.println("Enter Admin Name");
			String userName = sc.nextLine();

			System.out.println("Enter Admin Password");
			String choicePassword = sc.nextLine();
			String userPassword = null;
			try {
				userPassword = ExceptionsMethods.checkPassword(choicePassword);
			} catch (OMSException e) {
				e.getMessage();
				aLogin();
			}
			;

			System.out.println("Enter Admin email");
			String userEmail = null;
			String choiceEmail = sc.nextLine();
			try {
				userEmail = ExceptionsMethods.checkPassword(choiceEmail);
			} catch (OMSException e) {
				e.getMessage();
				aLogin();
			}
			;
			dao.registerAdmin(userId, userName, userEmail, userPassword);
		}
		System.out.println("enter 'y' to continue");
		System.out.println("enter 'n' to logout");
		String choiceUser = sc.nextLine();
		String button = null;
		try {
			button = ExceptionsMethods.charValidation(choiceUser);
		} catch (Exception e) {
			e.getMessage();
			aLogin();
		}
		if (button.equalsIgnoreCase("y")) {
			aLogin();
		} else if (button.equalsIgnoreCase("n")) {
			System.out.println("successfully logout");
			System.exit(0);
		}

	}// End of adminLogin()

}// End of Class
