package com.capgemini.medicalshopcollection.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicalshopcollection.beans.ProductBean;
import com.capgemini.medicalshopcollection.beans.UserBean;
import com.capgemini.medicalshopcollection.exception.ExceptionsMethods;
import com.capgemini.medicalshopcollection.exception.OMSException;
import com.capgemini.medicalshopcollection.main.MedicalMain;
import com.capgemini.medicalshopcollection.service.MedicalServices;
import com.capgemini.medicalshopcollection.service.MedicalservicesImpl;
import com.capgemini.medicalshopcollection.service.ProductServices;
import com.capgemini.medicalshopcollection.service.ProductServicesImpl;


public class UserTest {
	Scanner scanner = new Scanner(System.in);
	static MedicalServices medicalServices = new MedicalservicesImpl();
	static ProductServices productServices=new ProductServicesImpl();
	static ExceptionsMethods exceptionsMethods = new ExceptionsMethods();

	// Method to perform operation by user after login
	public void userLogin(UserBean userBean) {
		while (true) {
			System.out.println(
					"\nPress 1 to See Your Profile\nPress 2 to See Products\nPress 3 to Place Order\nPress 4 To See Discussion Board\nPress 5 to Logout");
			String userChoice1 = scanner.next();
			int userChoice = 0;
			try {
				userChoice = ExceptionsMethods.numberValidation(userChoice1);
			} catch (OMSException e1) {
				e1.getMessage();
			}

			switch (userChoice) {
			case 1:// See Profile
				 boolean bean=medicalServices.searchUser(userBean.getUserId());
				 if (bean) {
					  System.err.println("User Details");
					System.out.println(userBean.getUserName());
					System.out.println(userBean.getUserId());
					System.out.println(userBean.getEmail());
					System.out.println(userBean.getMobileNumber());
				}
				 break;

			case 2:// See Products
				new ProductsTest().showProducts();
				break;

			case 3:// Place Order
				new CartTest().cartOperation(userBean);
				break;

			case 4:// See discussion board
				break;

			case 5:// Logout
				System.exit(0);
				break;

			default:
				System.err.println("Enter Valid Option");
				break;
			}// Switch()
		} // End of while()
	}// End of afterUserLogin()

}// End of Class
