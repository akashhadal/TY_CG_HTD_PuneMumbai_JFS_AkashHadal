package com.capgemini.medicalshopcollection.main;

import java.util.Scanner;

import com.capgemini.medicalshopcollection.controller.LoginPage;
import com.capgemini.medicalshopcollection.controller.ProductsTest;
import com.capgemini.medicalshopcollection.controller.RegisterUser;
import com.capgemini.medicalshopcollection.exception.ExceptionsMethods;
import com.capgemini.medicalshopcollection.exception.OMSException;


public class MedicalMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("-------------WELCOME TO ONLINE MEDICAL SHOP------------");
			System.out.println("\nEnter 1 To Login\nEnter 2 to Register\nEnter 3 to see product List");
			String choice1 = sc.next();
			int choice = 0;
			try {
				choice = ExceptionsMethods.numberValidation(choice1);
			} catch (OMSException e) {
				e.getMessage();
			}

			switch (choice) {
			case 1:
				LoginPage loginPage=new LoginPage();
				loginPage.userLogin();
				break;

			case 2:// User Registration
				RegisterUser registerUser=new RegisterUser();
				registerUser.userRegister();
				LoginPage page=new LoginPage();
				page.userLogin();
				break;

			case 3:// Visitor
				new ProductsTest().showProducts();
				break;
				

			}// End of Switch()
		} // End of while()
	}// End of main()
}// End of Class
