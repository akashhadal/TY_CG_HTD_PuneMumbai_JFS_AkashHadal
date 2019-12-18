package com.capgemini.medicalshopcollection.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capgemini.medicalshopcollection.beans.UserBean;
import com.capgemini.medicalshopcollection.database.AdminUserData;


public class MedicalDAOCollectionsImpl implements MedicalDAO {
	AdminUserData adminUserData = new AdminUserData();
	HashMap<Integer, UserBean> userDb = adminUserData.userDB;

	@Override
	public UserBean userCheckEmail(String email) {
		UserBean userBean = null;
		for (Integer userId : userDb.keySet()) {
			userBean = userDb.get(userId);
			if (userBean.getEmail().equals(email)) {
				return userBean;
			}
		}
		return userBean;

	}// End of userCheckEmail()
	@Override
	public boolean loginUser(UserBean userBean, String password) {
		if (userBean.getPassword().equalsIgnoreCase(password)) {
			return true;
		} else {
			return false;
		}
	}// End of loginUser()

	@Override
	public boolean userRegister(UserBean userBean) {
		if (userDb.containsKey(userBean.getUserId()) != true) {
			userDb.put(userBean.getUserId(), userBean);
			System.out.println("Successfully Registered");
			return true;
		} else {
			System.err.println("User with the same id does already exist");
			return false;
		}
	}// End of userRegister()

	@Override
	public boolean searchUser(int userId) {
		boolean ispresent = false;
		if (userDb.containsKey(userId)) {
			ispresent = true;
		} else {
			ispresent = false;
		}
		return ispresent;
	}// End of searchUser()

	@Override
	public boolean removeUser(int userId) {
		if (userDb.containsKey(userId)) {
			UserBean userBean = userDb.get(userId);
			// Remove user
			userDb.remove(userId);
			return true;
		} else {
			System.err.println("User with this id does not exist");
			return false;
		}

	}// End of removeUser()

	@Override
	public List<UserBean> getAllUsers(String userType) {

		List<UserBean> usersList = new ArrayList<UserBean>();
		for (Integer userId : userDb.keySet()) {
			UserBean userBean = userDb.get(userId);
			// Booking ticket = bookingDb.get(bookingId);
			if (userBean.getUserType().equals("User")) {
				usersList.add(userBean);
			}

		}
		return usersList;
	}// End of getAllUsers()

}// End of Class
