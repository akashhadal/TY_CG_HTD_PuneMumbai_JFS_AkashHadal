package com.capgemini.springmvc.medicalshop.service;

import java.util.List;

import com.capgemini.springmvc.medicalshop.beans.AdminBean;
import com.capgemini.springmvc.medicalshop.beans.UserBean;

public interface MedicalShopService {

	public boolean registerUser(UserBean userBean);

	public UserBean loginUser(String name, String password);

	public AdminBean loginAdmin(String name, String password);

	public List<UserBean> getAllUser();

	public boolean updateUserProfile(UserBean userBean);

	public boolean removeUser(int userId);

}// End of Service
