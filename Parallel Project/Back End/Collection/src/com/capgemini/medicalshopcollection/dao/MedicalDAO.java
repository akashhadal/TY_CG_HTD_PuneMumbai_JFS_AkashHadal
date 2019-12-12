package com.capgemini.medicalshopcollection.dao;

import java.util.List;

import com.capgemini.medicalshopcollection.beans.UserBean;


public interface MedicalDAO {
	// Login
	public UserBean userCheckEmail(String email);

	public boolean loginUser(UserBean userBean, String password);

	// User register
	public boolean userRegister(UserBean userBean);

	public boolean searchUser(int userId);

	public boolean removeUser(int userId);

	public List<UserBean> getAllUsers(String userType);

}// End of interface
