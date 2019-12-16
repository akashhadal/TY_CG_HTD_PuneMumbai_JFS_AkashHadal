package com.capgemini.medicalshop.dao;

import java.util.List;

import com.capgemini.medicalshop.beans.LoginBean;

public interface medicalShopDAO {

	public boolean registerUser(LoginBean loginBean);

	public LoginBean login(String email, String password);

	public List<LoginBean> getAllUser();

	public boolean updateUserProfile(LoginBean loginBean);

	public boolean removeUser(int userId);

	public List<LoginBean> userProfile(int userId);

}
