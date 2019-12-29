package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.dao.AdminUserDAO;


@Service
public class AdminUserServiceImplementation implements AdminUserService {

	@Autowired
	private AdminUserDAO adminUserDAO;

	@Override
	public AdminUserBean login(String userEmail, String password) {
		return adminUserDAO.login(userEmail, password);
	}

	@Override
	public boolean userRegister(AdminUserBean adminUserBean) {
		return adminUserDAO.userRegister(adminUserBean);
	}

	@Override
	public List<AdminUserBean> getAllUsers() {
		return adminUserDAO.getAllUsers();
	}

	@Override
	public List<AdminUserBean> getAllEmployee() {
		return adminUserDAO.getAllEmployee();
	}

	@Override
	public boolean deleteUser(int userId) {
		return adminUserDAO.deleteUser(userId);
	}

	@Override
	public boolean deleteEmployee(int userId) {
		return adminUserDAO.deleteEmployee(userId);
	}

	@Override
	public boolean emailPresent(String email) {
		return adminUserDAO.emailPresent(email);
	}

	@Override
	public List<AdminUserBean> managerList() {
		return adminUserDAO.managerList();
	}

	@Override
	public boolean deleteManager(int userId) {
		return adminUserDAO.deleteManager(userId);
	}

	@Override
	public boolean passwordChecker(String userEmail, String password) {
		return adminUserDAO.passwordChecker(userEmail, password);
	}

	@Override
	public AdminUserBean userProfile(int userId) {
		return adminUserDAO.userProfile(userId);
	}

	@Override
	public boolean updateProfile(AdminUserBean adminUserBean) {
		return adminUserDAO.updateProfile(adminUserBean);
	}
	
}
