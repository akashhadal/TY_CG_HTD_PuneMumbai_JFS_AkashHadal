package com.capgemini.medicalshop.dao;

import com.capgemini.medicalshop.bean.UserBean;

public interface medicalShopDAO {
	
	public UserBean registerUser(int uId, String name,String email,String password);
	
	public int loginUser(String name,String password);
	
	public int loginAdmin(String name,String password);
	
	public UserBean getAllUser();
	
	public UserBean updateUserProfile(int uId);
	
	public boolean removeUser(int userId);
	
}
