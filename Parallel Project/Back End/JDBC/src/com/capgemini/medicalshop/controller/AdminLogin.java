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

		System.out.println("Enter Email");
		String adminEmail= sc.nextLine();
		try {
			String choiceEmail = ExceptionsMethods.emailValidator(adminEmail);
		} catch (OMSException e) {
			e.getMessage();
			aLogin();
		}

		System.out.println("Enter Password");
		String adminPassword = sc.nextLine();
		try {
			String choice=ExceptionsMethods.checkPassword(adminPassword);
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
		

	}// End of adminLogin()

}// End of Class
