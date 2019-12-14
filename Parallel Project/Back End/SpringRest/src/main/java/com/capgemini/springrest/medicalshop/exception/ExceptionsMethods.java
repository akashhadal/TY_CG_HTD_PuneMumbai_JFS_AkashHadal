package com.capgemini.springrest.medicalshop.exception;

import com.capgemini.springrest.medicalshop.validation.Validations;
import com.capgemini.springrest.medicalshop.validation.ValidationsImpli;

public class ExceptionsMethods {
	static Validations validations = new ValidationsImpli();

	// Exceptions Method for Number Validation
	public static Integer numberValidation(String num) throws OMSException {
		Integer num1 = validations.validateNumber(num);
		if (num1 != null) {
			return num1;
		} else {
			throw new OMSException("Invalid Input Entered\nPlease Enter Input In Number Format");
		}
	}

	// Exception method for contact number validator
	public Long contactValidator(String mobileNumber) throws OMSException {
		Long mobileNumber1 = validations.contactValidate(mobileNumber);
		if (mobileNumber1 != null) {
			return mobileNumber1;
		}
		throw new OMSException("Please enter the 10 digit mobile number ");
	}

	// Method to check email format is valid or not
	public static String emailValidator(String email) throws OMSException {
		String emailId = validations.emailIdValidate(email);
		if (emailId != null) {
			return emailId;
		} else {
			throw new OMSException("Enter the Correct Email");
		}
	}

	// Method to check Card number during payment
	public Long cardNumberValidator(String cardNumber) throws OMSException {
		Long cardNumber1 =validations.cardNumberValidator(cardNumber);
		if (cardNumber1 != null) {
			return cardNumber1;
		}
		throw new OMSException("Please Enter 16 digit Card Number");
	}

	// Method to check month range
	public int checkMonth(int month) throws OMSException {
		int month1 = validations.month(month);
		if (month1 != 0) {
			return month1;
		}
		throw new OMSException("Please Enter Valid Month !!! Enter Month Between 1 to 12");
	}

	// Method check year format
	public static Integer checkYear(String year) throws OMSException {
		Integer num1 = validations.year(year);
		if (num1 != null) {
			return num1;
		} else {
			throw new OMSException("Year should be 4 digits");
		}
	}

	// Method to check CVV
	public static Integer checkCVV(String cvv) throws OMSException {
		Integer num1 = validations.year(cvv);
		if (num1 != null) {
			return num1;
		} else {
			throw new OMSException("CVV number should be 4 digits");
		}
	}

	// Method to check password validation
	public static String checkPassword(String password) throws OMSException {
		String password1 = validations.passwordValidate(password);
		if (password1 != null) {
			return password1;
		} else {
			throw new OMSException("Password must be Minimum of 8 Characters");
		}
	}

	// Method to check Character validation
	public static String charValidation(String character) throws OMSException {
		String character1 = validations.charValidate(character);
		if (character1 != null) {
			return character1;
		} else {
			throw new OMSException("Invalid Input Format\nPlease Enter Single character");
		}
	}
}// End of Class
