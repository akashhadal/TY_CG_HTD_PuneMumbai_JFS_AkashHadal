 package com.capgemini.medicalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalshop.beans.LoginBean;
import com.capgemini.medicalshop.dao.medicalShopDAO;


@Service
public class MedicalShopSeriveceImpli implements MedicalShopService {

	@Autowired
	private medicalShopDAO dao;
	



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
	public boolean registerUser(LoginBean loginBean) {
		if(loginBean!=null) {
			
		}
		return dao.registerUser(loginBean);
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
