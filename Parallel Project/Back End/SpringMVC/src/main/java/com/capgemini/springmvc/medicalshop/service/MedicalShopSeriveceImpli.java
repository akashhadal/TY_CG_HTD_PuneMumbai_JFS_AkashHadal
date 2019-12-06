 package com.capgemini.springmvc.medicalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springmvc.medicalshop.beans.AdminBean;
import com.capgemini.springmvc.medicalshop.beans.UserBean;
import com.capgemini.springmvc.medicalshop.dao.medicalShopDAO;

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
	public List<UserBean> getAllUser() {
		return dao.getAllUser();
	}

	@Override
	public boolean updateUserProfile(UserBean userBean) {
		return dao.updateUserProfile(userBean);
	}

	@Override
	public boolean removeUser(int userId) {
		return dao.removeUser(userId);
	}

	
}//End of Service
