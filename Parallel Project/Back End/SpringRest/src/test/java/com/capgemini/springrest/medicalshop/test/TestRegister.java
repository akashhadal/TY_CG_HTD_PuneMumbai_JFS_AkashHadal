package com.capgemini.springrest.medicalshop.test;

import static org.testng.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.springrest.medicalshop.beans.LoginBean;
import com.capgemini.springrest.medicalshop.dao.medicalShopDAO;

public class TestRegister {
	
	@Autowired
	private medicalShopDAO medicalShopDAO;
	
	@Test
	public void testValidUserRegistration() {
		LoginBean loginBean=new LoginBean();
		loginBean.setUserId(1111);
		loginBean.setUserName("aaaa");
		loginBean.setUserEmail("aaaa@gmail.com");
		loginBean.setUserPassword("aaaa@123");
		loginBean.setRole("User");
		
		assertEquals(true, medicalShopDAO.registerUser1(loginBean));
	}

}
