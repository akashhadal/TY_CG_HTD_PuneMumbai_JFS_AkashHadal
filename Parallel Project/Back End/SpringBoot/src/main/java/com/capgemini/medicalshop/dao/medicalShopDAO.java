package com.capgemini.medicalshop.dao;

import java.util.List;

import com.capgemini.medicalshop.beans.AdminBean;
import com.capgemini.medicalshop.beans.LoginBean;
import com.capgemini.medicalshop.beans.UserBean;



public interface medicalShopDAO {

	public boolean registerUser(UserBean userBean);
	
	public boolean registerUser1(LoginBean loginBean);

	public UserBean loginUser(String name, String password);
	
	public LoginBean login(String name, String password);

	public AdminBean loginAdmin(String name, String password);

	public List<LoginBean> getAllUser();

	public boolean updateUserProfile(LoginBean loginBean);

	public boolean removeUser(int userId);
	
	public List<LoginBean> userProfile(int userId);
	

}
