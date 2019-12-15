package com.capgemini.springrest.medicalshop.test;

import static org.testng.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.springrest.medicalshop.beans.LoginBean;
import com.capgemini.springrest.medicalshop.dao.medicalShopDAO;

public class TestLogin {

	@Autowired
	private medicalShopDAO medicalShopDAO;
	
	@Test
	public void testValidUserLogin() {
//		LoginBean loginBean=new LoginBean();
//		loginBean.setUserEmail("pooja@gmail.com");
//		loginBean.setUserPassword("pooja@123");
		//LoginBean bean=medicalShopDAO.login(loginBean.getUserEmail(), loginBean.getUserPassword());
		LoginBean bean=medicalShopDAO.login("pooja@gmail.com", "pooja@123");
		String expected="User";
		String actual=bean.getRole();
		
		assertEquals(actual, expected);
	}
}
