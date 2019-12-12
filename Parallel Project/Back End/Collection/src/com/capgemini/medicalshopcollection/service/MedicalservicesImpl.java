package com.capgemini.medicalshopcollection.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.medicalshopcollection.beans.UserBean;
import com.capgemini.medicalshopcollection.dao.MedicalDAO;
import com.capgemini.medicalshopcollection.dao.MedicalDAOCollectionsImpl;


public class MedicalservicesImpl implements MedicalServices {
	//Create Object of MedicalDAO
	MedicalDAO medicalDAO = new MedicalDAOCollectionsImpl();

	@Override
	public UserBean userCheckEmail(String email) {
		return medicalDAO.userCheckEmail(email);
	}

	@Override
	public boolean loginUser(UserBean userBean, String password) {
		return medicalDAO.loginUser(userBean, password);
	}

	@Override
	public boolean userRegister(UserBean userBean) {
		return medicalDAO.userRegister(userBean);
	}

	@Override
	public boolean searchUser(int userId) {
		return medicalDAO.searchUser(userId);
	}

	@Override
	public boolean removeUser(int userId) {
		return medicalDAO.removeUser(userId);
	}

	@Override
	public List<UserBean> getAllUsers(String userType) {
		return medicalDAO.getAllUsers(userType);
	}

	// Regex
	/*
	 * @Override public Integer validateNumber(String id) { Pattern pat =
	 * Pattern.compile("\\d+"); Matcher mat = pat.matcher(id); if (mat.matches()) {
	 * return Integer.parseInt(id); } else { return null; } }// End of
	 * numberValidate()
	 * 
	 * @Override public String emailIdValidate(String email) { Pattern pat =
	 * Pattern.compile("\\w+\\@\\w+\\.\\w+"); Matcher mat = pat.matcher(email); if
	 * (mat.matches()) { return email; } else { return null; } }// End of
	 * emailIdValidate()
	 */
	/*
	 * @Override public Double doubleValidate(String number) { Pattern pat =
	 * Pattern.compile("\\d+.\\d\\d"); Matcher mat = pat.matcher(number); if
	 * (mat.matches()) { return Double.parseDouble(number); } return null; }// End
	 * of doubleValidate()
	 * 
	 * @Override public Long contactValidate(String contact) { Pattern pat =
	 * Pattern.compile("\\d{10}"); Matcher mat = pat.matcher(contact); if
	 * (mat.matches()) { return Long.parseLong(contact); } return null; }// End of
	 * contactValidate()
	 * 
	 * @Override public String passwordValidate(String password) { Pattern pat =
	 * Pattern.compile(".{8,}"); Matcher mat = pat.matcher(password); if
	 * (mat.matches()) { return password; } return null; }//End of
	 * passwordValidate()
	 * 
	 * @Override public String charValidate(String character) { Pattern pat =
	 * Pattern.compile("[a-z]"); Matcher mat = pat.matcher(character); if
	 * (mat.matches()) { return character; } return null; }//End of
	 * passwordValidate()
	 */	
	

}// End of Class
