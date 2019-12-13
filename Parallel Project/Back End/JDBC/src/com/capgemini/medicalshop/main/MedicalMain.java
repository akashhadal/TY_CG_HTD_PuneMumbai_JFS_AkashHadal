package com.capgemini.medicalshop.main;

import java.util.Scanner;

import com.capgemini.medicalshop.bean.ProductBean;
import com.capgemini.medicalshop.controller.AdminLogin;
import com.capgemini.medicalshop.controller.UserLogin;
import com.capgemini.medicalshop.dao.ProductDao;
import com.capgemini.medicalshop.exception.ExceptionsMethods;
import com.capgemini.medicalshop.exception.OMSException;
import com.capgemini.medicalshop.factory.ProductFactory;

public class MedicalMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		

		System.out.println("Which Mode you want to Enter");
		System.out.println("Enter 1 for Admin\nEnter 2 for User\nEnter 3 to See All Products\nEnter 0 to exit");
		String select = sc.nextLine();

		int choice = 0;
		try {
			choice = ExceptionsMethods.numberValidation(select);
		} catch (OMSException e) {
			e.getMessage();
			main(args);
		}
		
		if (choice == 1) {
			System.out.println("...Admin Login...");
			AdminLogin adminLogin = new AdminLogin();
			adminLogin.aLogin();
		} else if (choice == 2) {
			System.out.println(".....User Login....");
			UserLogin userLogin = new UserLogin();
			userLogin.user();
		}else if (choice==3) {
			System.out.println("Products List");
			ProductDao productDao = ProductFactory.getProductInstance();
			ProductBean bean = productDao.getAllProduct();
		}else if (choice==0) {
			System.exit(0);
		}else {
			System.err.println("Enter Valid No.");
			main(args);
		}

		
		System.out.println("enter 'y' to continue");
		System.out.println("enter 'n' to logout");
		String button = sc.nextLine();
		String charChoice;
		try {
			charChoice = ExceptionsMethods.charValidation(button);
			if (charChoice.equalsIgnoreCase("y")) {
				main(args);
			} else if (charChoice.equalsIgnoreCase("n")) {
				System.out.println("Thank You For Visiting");
				System.exit(0);
			}
		} catch (OMSException e) {
			e.getMessage();
			main(args);
		}
		

	}// End of Main

}// End of Class
