package com.capgemini.medicalshopcollection.validation;

public interface Validations {

	public Integer validateNumber(String id);

	public String emailIdValidate(String email);

	public Double doubleValidate(String number);

	public Long contactValidate(String contact);

	public String passwordValidate(String password);

	public String charValidate(String character);

	public Long cardNumberValidator(String cardNumber);

	public int month(int month);

	public Integer year(String year);

	public Integer checkCVV(String cvv);
	
	public  boolean userNameValidate(String userName);

}
