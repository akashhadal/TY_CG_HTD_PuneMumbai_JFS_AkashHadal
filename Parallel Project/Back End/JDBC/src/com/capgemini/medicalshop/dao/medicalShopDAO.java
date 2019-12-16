package com.capgemini.medicalshop.dao;

import com.capgemini.medicalshop.bean.AdminBean;
import com.capgemini.medicalshop.bean.UserBean;

public interface MedicalShopDAO {
	
	public UserBean registerUser(int uId, String name,String email,String password);
	
	public boolean registerAdmin(int id, String name,String email,String password);
	
	public int loginUser(String email,String password);
	
	public int loginAdmin(String email,String password);
	
	public UserBean getAllUser();
	
	public UserBean updateUserProfile(int uId);
	
	public boolean removeUser(int userId);
	
}
