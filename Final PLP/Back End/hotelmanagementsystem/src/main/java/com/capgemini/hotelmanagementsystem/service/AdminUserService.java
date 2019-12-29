package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;

public interface AdminUserService {

	// admin login
	public AdminUserBean login(String userEmail, String password);

	// registeration only for customer
	public boolean userRegister(AdminUserBean adminUserBean);

	// see all customer which is present in database
	public List<AdminUserBean> getAllUsers();

	// see all employee which is present in database
	public List<AdminUserBean> getAllEmployee();

	// delete customer by admin
	public boolean deleteUser(int userId);

	// delete Employee by admin
	public boolean deleteEmployee(int userId);

	// user update his details or add
	public AdminUserBean userProfile(int userId);


	// Email checker
	public boolean emailPresent(String email);

	// Password checker
	public boolean passwordChecker(String userEmail, String password);

	// list of manager
	public List<AdminUserBean> managerList();

	// remove Manager by admin
	public boolean deleteManager(int userId);
	

	//To Update User Profile
		public boolean updateProfile (AdminUserBean adminUserBean);

}
