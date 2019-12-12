package com.capgemini.hibernate.medicashophibernate.controller;

import java.util.Scanner;

import com.capgemini.hibernate.medicashophibernate.dao.medicalShopDAO;
import com.capgemini.hibernate.medicashophibernate.factory.medicalShopFactory;


public class AdminLogin {

	public void aLogin() {
		Scanner sc = new Scanner(System.in);
		medicalShopDAO dao = medicalShopFactory.getInstance();

		System.out.println("Enter name");
		String adminName = sc.nextLine();
		System.out.println("Enter Password");
		String adminPassword = sc.nextLine();

		int admin = dao.loginAdmin(adminName, adminPassword);

		int getUserId = admin;
		if (getUserId > 0) {
			Admin at = new Admin();
			at.adminTest();	

		} else {
			System.out.println("Admin Login Failed");
		}

	}// End of adminLogin()

}// End of Class
