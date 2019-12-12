package com.capgemini.medicalshopcollection.service;

import java.util.List;

import com.capgemini.medicalshopcollection.beans.UserBean;


public interface MedicalServices {
	// Login
	public boolean loginUser(UserBean userBean, String password);

	public UserBean userCheckEmail(String email);

	// User register
	public boolean userRegister(UserBean userBean);

	public boolean searchUser(int userId);
	
	public boolean removeUser(int userId);

	public List<UserBean> getAllUsers(String userType);


	// Regex
	/*
	 * public Integer validateNumber(String id);
	 * 
	 * public String emailIdValidate(String email);
	 * 
	 * public Double doubleValidate(String number);
	 * 
	 * public Long contactValidate(String contact);
	 * 
	 * public String passwordValidate(String password);
	 * 
	 * public String charValidate(String character);
	 */
	
}// End of interface
