package com.capgemini.medicalshop.service;

import java.util.List;

import com.capgemini.medicalshop.beans.AdminBean;
import com.capgemini.medicalshop.beans.LoginBean;
import com.capgemini.medicalshop.beans.UserBean;



public interface MedicalShopService {

	
	public boolean registerUser(LoginBean loginBean);
	
	public LoginBean login(String email, String password);

	public List<LoginBean> getAllUser();

	public boolean updateUserProfile(LoginBean loginBean);

	public boolean removeUser(int userId);
	
	public List<LoginBean> userProfile(int userId);

}// End of Service
