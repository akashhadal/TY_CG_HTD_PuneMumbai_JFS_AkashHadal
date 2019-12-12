package com.capgemini.medicalshop.main;

import java.util.Scanner;

import com.capgemini.medicalshop.bean.ProductBean;
import com.capgemini.medicalshop.controller.AdminLogin;
import com.capgemini.medicalshop.controller.UserLogin;
import com.capgemini.medicalshop.dao.ProductDao;
import com.capgemini.medicalshop.factory.ProductFactory;

public class MedicalMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		

		System.out.println("Which Mode you want to Enter");
		System.out.println("Enter 1 for Admin\nEnter 2 for User\nEnter 3 to See All Products\nEnter 0 to exit");
		int select = Integer.parseInt(sc.nextLine());

		if (select == 1) {
			System.out.println("...Admin Login...");
			AdminLogin adminLogin = new AdminLogin();
			adminLogin.aLogin();
		} else if (select == 2) {
			System.out.println(".....User Login....");
			UserLogin userLogin = new UserLogin();
			userLogin.user();
		}else if (select==3) {
			System.out.println("Products List");
			ProductDao productDao = ProductFactory.getProductInstance();
			ProductBean bean = productDao.getAllProduct();
		}else if (select==0) {
			System.exit(0);
		}

		
		System.out.println("enter 'y' to continue");
		System.out.println("enter 'n' to logout");
		String button = sc.nextLine();
		if (button.equalsIgnoreCase("y")) {
			main(args);
		} else if (button.equalsIgnoreCase("n")) {
			System.out.println("Thank You For Visiting");
			System.exit(0);
		}

	}// End of Main

}// End of Class
