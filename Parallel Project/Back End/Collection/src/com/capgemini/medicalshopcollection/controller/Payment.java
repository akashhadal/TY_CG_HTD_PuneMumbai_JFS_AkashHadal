package com.capgemini.medicalshopcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalshopcollection.beans.UserBean;
import com.capgemini.medicalshopcollection.exception.ExceptionsMethods;
import com.capgemini.medicalshopcollection.exception.OMSException;
import com.capgemini.medicalshopcollection.service.CartServices;
import com.capgemini.medicalshopcollection.service.CartServicesImpl;


public class Payment {
	Scanner scanner = new Scanner(System.in);
	static CartServices cartServices = new CartServicesImpl();
	static ExceptionsMethods exceptionsMethods = new ExceptionsMethods();
	static boolean validation = true;

	public void payment(UserBean userBean) {

		System.out.println("Enter Your Adress");
		String address = scanner.nextLine();

		System.out.println("\nPlease Enter Your Card Details To Complete Your Transaction!!!");

		Long cardNumber = 0L;
		validation = true;
		while (validation) {
			System.out.println("Enter Your Card Number: ");
			String cardNumber1 = scanner.next();
			try {
				cardNumber = exceptionsMethods.cardNumberValidator(cardNumber1);
				validation = false;
			} catch (OMSException e) {
				e.getMessage();
			}
		}
		scanner.nextLine();
		System.out.println("Enter Your Name On Card");
		scanner.nextLine();

		validation = true;
		while (validation) {
			System.out.println("Expiry Month: ");
			int month1 = scanner.nextInt();
			try {
				int month = exceptionsMethods.checkMonth(month1);
				validation = false;
			} catch (OMSException e) {
				e.getMessage();
			}
		}

		validation = true;
		while (validation) {
			System.out.print("Expiry Year: ");
			String year1 = scanner.next();
			try {
				int year = ExceptionsMethods.checkYear(year1);
				validation = false;
			} catch (OMSException e) {
				e.getMessage();
			}
		}
		
		validation = true;
		while (validation) {
			System.out.println("CVV: ");
			String cvv1 = scanner.next();
			try {
				int cvv = ExceptionsMethods.checkCVV(cvv1);
				validation = false;
			} catch (OMSException e) {
				e.getMessage();
			}
		}

		System.out.println("Total Bill is = " + cartServices.totalBill(userBean.getUserId()));
		System.out.println("TRANSACTION IS SUCCESSFULL");
		System.out.println("***THANK YOU FOR ORDERING***");

	}// End of payment()

}// End of Class
