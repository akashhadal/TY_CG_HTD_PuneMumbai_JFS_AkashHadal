package com.capgemini.medicalshopcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalshopcollection.beans.UserBean;
import com.capgemini.medicalshopcollection.exception.ExceptionsMethods;
import com.capgemini.medicalshopcollection.exception.OMSException;
import com.capgemini.medicalshopcollection.service.MedicalServices;
import com.capgemini.medicalshopcollection.service.MedicalservicesImpl;
import com.capgemini.medicalshopcollection.validation.Validations;
import com.capgemini.medicalshopcollection.validation.ValidationsImpli;


public class LoginPage {
	static MedicalServices medicalServices = new MedicalservicesImpl();
	static ExceptionsMethods exceptionsMethods = new ExceptionsMethods();
	static Validations validations=new ValidationsImpli();
	static boolean flag = true;
	static String emailId;

	public void userLogin() {
		Scanner scanner = new Scanner(System.in);
		flag = true;
		while (flag) {
			System.out.println("Enter Your Email: ");
			String email = scanner.nextLine();
			try {
				emailId = ExceptionsMethods.emailValidator(email);
				flag = false;
			} catch (OMSException e) {
				e.getMessage();
			}
		}

		System.out.println("Enter Password");
		String password = scanner.nextLine();

		// To check email present or not and get All data
		UserBean userBean = medicalServices.userCheckEmail(emailId);
		if (userBean != null) {
			if (medicalServices.loginUser(userBean, password)) {
				System.out.println("---------------Successfully Logged In---------------");
				System.out.println("*********WELCOME " + userBean.getUserName() + "*********");

				if (userBean.getUserType().equals("Admin")) {
					System.out.println("Admin Id = " + userBean.getUserId());
					System.out.println("Email = " + userBean.getEmail());
					System.out.println("Mobile  = " + userBean.getMobileNumber());
					new AdminTest().adminLogin();
				} else {
					System.out.println("Users Id = " + userBean.getUserId());
					System.out.println("Email = " + userBean.getEmail());
					System.out.println("Mobile  = " + userBean.getMobileNumber());
					new UserTest().userLogin(userBean);
				}
			} else {
				System.err.println("Enter Valid Password");
				userLogin();
			}
		} else {
			System.err.println("Entered User Id Not Preset");
			userLogin();
		}
	}

}// End of Class
