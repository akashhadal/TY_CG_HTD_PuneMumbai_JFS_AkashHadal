package com.capgemini.springrest.medicalshop.dao;

import java.util.List;

import com.capgemini.springrest.medicalshop.beans.AdminBean;
import com.capgemini.springrest.medicalshop.beans.LoginBean;
import com.capgemini.springrest.medicalshop.beans.UserBean;


public interface medicalShopDAO {

	public boolean registerUser(UserBean userBean);
	
	public boolean registerUser1(LoginBean loginBean);

	public UserBean loginUser(String name, String password);

	public AdminBean loginAdmin(String name, String password);

	public List<UserBean> getAllUser();

	public boolean updateUserProfile(UserBean userBean);

	public boolean removeUser(int userId);
	

}
