package com.capgemini.hibernate.medicashophibernate.dao;

import java.util.List;

import com.capgemini.hibernate.medicashophibernate.beans.UserBean;

public interface medicalShopDAO {
	
	public UserBean registerUser(int uId, String name,String email,String password);
	
	public UserBean loginUser(String name,String password);
	
	public int loginAdmin(String name,String password);
	
	public List<UserBean> getAllUser();
	
	public UserBean updateUserProfile(int uId, String name,String email,String password);
	
	public boolean removeUser(int userId);
	
	public UserBean getUser(int userId);
	
}
