package com.capgemini.medicalshopcollection.database;

import java.util.HashMap;

import com.capgemini.medicalshopcollection.beans.UserBean;


public class AdminUserData {
	public static HashMap<Integer, UserBean> userDB = new HashMap<>();
	
	public AdminUserData() {
		UserBean userBean1 = new UserBean();
		userBean1.setUserId(1);
		userBean1.setUserName("Akash Ramesh Hadal");
		userBean1.setEmail("akash@gmail.com");
		userBean1.setMobileNumber(7066705430l);
		userBean1.setPassword("akash1234");
		userBean1.setUserType("Admin");
		userDB.put(userBean1.getUserId(), userBean1);
		
		UserBean userBean2 = new UserBean();
		userBean2.setUserId(2);
		userBean2.setUserName("Diksha Thool");
		userBean2.setEmail("diksha@gmail.com");
		userBean2.setMobileNumber(8983464070l);
		userBean2.setPassword("diksha1234");
		userBean2.setUserType("User");
		userDB.put(userBean2.getUserId(), userBean2);
		
		UserBean userBean3 = new UserBean();
		userBean3.setUserId(3);
		userBean3.setUserName("Pooja Vishwakarma");
		userBean3.setEmail("pooja@gmail.com");
		userBean3.setMobileNumber(9754123685l);
		userBean3.setPassword("pooja1234");
		userBean3.setUserType("User");
		userDB.put(userBean3.getUserId(), userBean3);
		
	}//End of Constructor AdminUserData()

}//End of class
