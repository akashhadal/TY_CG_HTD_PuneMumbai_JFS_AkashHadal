 package com.capgemini.springrest.medicalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springrest.medicalshop.beans.AdminBean;
import com.capgemini.springrest.medicalshop.beans.LoginBean;
import com.capgemini.springrest.medicalshop.beans.UserBean;
import com.capgemini.springrest.medicalshop.dao.medicalShopDAO;




@Service
public class MedicalShopSeriveceImpli implements MedicalShopService {

	@Autowired
	private medicalShopDAO dao;
	
	@Override
	public boolean registerUser(UserBean userBean) {
		return dao.registerUser(userBean);
	}

	@Override
	public UserBean loginUser(String name, String password) {
		return dao.loginUser(name, password);
	}

	@Override
	public AdminBean loginAdmin(String name, String password) {
		return dao.loginAdmin(name, password);
	}

	@Override
	public List<LoginBean> getAllUser() {
		return dao.getAllUser();
	}

	@Override
	public boolean updateUserProfile(LoginBean userBean) {
		return dao.updateUserProfile(userBean);
	}

	@Override
	public boolean removeUser(int userId) {
		return dao.removeUser(userId);
	}

	@Override
	public boolean registerUser1(LoginBean loginBean) {
		return dao.registerUser1(loginBean);
	}

	@Override
	public LoginBean login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public List<LoginBean> userProfile(int userId) {
		return dao.userProfile(userId);
	}

	
}//End of Service
