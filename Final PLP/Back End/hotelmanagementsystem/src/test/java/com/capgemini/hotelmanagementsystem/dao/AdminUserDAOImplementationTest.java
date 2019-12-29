package com.capgemini.hotelmanagementsystem.dao;


import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminUserDAOImplementationTest {


	@Autowired
	private AdminUserDAO adminUserDAO;

	public AdminUserBean adminUserBean;

	@BeforeEach
	public void createObject() {
		adminUserBean = new AdminUserBean();
	}

	@Test
	void testLogin() {
		AdminUserBean adminUserBean = new AdminUserBean();
		String userEmail = "suraj@gmail.com";
		String password = "suraj@95";
		adminUserBean = adminUserDAO.login(userEmail, password);
		String expected = "admin";
		String actual = adminUserBean.getUserType();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void userRegister() {
		adminUserBean = new AdminUserBean();
		adminUserBean.setUserName("kam dige");
		adminUserBean.setUserType("user");
		adminUserBean.setPassword("Kam@0123");
		adminUserBean.setUserEmail("mam@04gmail.com");

		boolean expected = true;
		boolean actual = adminUserDAO.userRegister(adminUserBean);
		Assert.assertEquals(expected, actual);

	}

	@Test
	void testGetAllUsers() {
		TestCase.assertNotNull(adminUserDAO.getAllUsers());
	}

	@Test
	void testGetAllEmployee() {
		TestCase.assertNotNull(adminUserDAO.getAllEmployee());
	}

//	@Test
//	void testDeleteEmployee() {
//		adminUserBean = new AdminUserBean();
//		TestCase.assertEquals(true, adminUserDAO.deleteEmployee(6));
//	}

	@Test
	void testDeleteUser() {
		adminUserBean = new AdminUserBean();
		TestCase.assertEquals(true, adminUserDAO.deleteUser(10));
	}


}
