package com.capgemini.medicalshopcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalshopcollection.beans.UserBean;
import com.capgemini.medicalshopcollection.exception.ExceptionsMethods;
import com.capgemini.medicalshopcollection.exception.OMSException;
import com.capgemini.medicalshopcollection.service.MedicalServices;
import com.capgemini.medicalshopcollection.service.MedicalservicesImpl;


public class RegisterUser {
	static MedicalServices medicalServices = new MedicalservicesImpl();
	static boolean validation = true;
	static String emailId;
	static String password1;
	static ExceptionsMethods exceptionsMethods = new ExceptionsMethods();

	public void userRegister() {
		UserBean userBean = new UserBean();
		Scanner scanner = new Scanner(System.in);
		
		while (validation) {
			System.out.println("Enter User Id: ");
			String userId1 = scanner.next();
			int userId = 0;
			try {
				userId = ExceptionsMethods.numberValidation(userId1);
				boolean state = medicalServices.searchUser(userId);

				if (state == false) {
					userBean.setUserId(userId);
					scanner.nextLine();
					System.out.println("Enter your Name: ");
					userBean.setUserName(scanner.nextLine());
					validation = false;
				}
			} catch (OMSException  e1) {
				e1.getMessage();
			}
		}
		
		validation = true;
		while (validation) {
			System.out.println("Enter your Email: ");
			String email = scanner.nextLine();
			try {
				emailId = ExceptionsMethods.emailValidator(email);
				validation = false;
			} catch (OMSException e) {
				e.getMessage();
			}
		}
		userBean.setEmail(emailId);

		Long mobileNumber = null;
		validation = true;
		while (validation) {
			System.out.println("Enter your Mobile Number: ");
			String mobileNumber1 = scanner.next();
			scanner.nextLine();
			try {
				mobileNumber = exceptionsMethods.contactValidator(mobileNumber1);
				validation = false;
			} catch (OMSException e) {
				e.getMessage();
			}
		}
		userBean.setMobileNumber(mobileNumber);
		
		validation = true;
		while (validation) {
			System.out.println("Enter Password: ");
			String password = scanner.nextLine();
			try {
				password1 = ExceptionsMethods.checkPassword(password);
				validation = false;
			} catch (OMSException e) {
				e.getMessage();
			}
		}
		userBean.setPassword(password1);
		
		System.out.println("Enter User Type: ");
		userBean.setUserType(scanner.nextLine());
		
		boolean user = medicalServices.userRegister(userBean);
		if (user == true) {
			System.out.println("Registered Successfully");
			System.out.println(userBean.getEmail());
			System.out.println(userBean.getPassword());
			
		} else {
			System.err.println("Unable To Registered");
		}
	}// End of userRegister()

}// End of Class
