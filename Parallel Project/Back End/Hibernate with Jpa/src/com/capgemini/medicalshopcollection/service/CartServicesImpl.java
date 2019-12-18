package com.capgemini.medicalshopcollection.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.medicalshopcollection.beans.CartBean;
import com.capgemini.medicalshopcollection.dao.CartDAO;
import com.capgemini.medicalshopcollection.dao.CartDAOImpl;


public class CartServicesImpl implements CartServices {
	CartDAO cartDAO = new CartDAOImpl();
	static int uniqueId = 3;

	@Override
	public boolean addIntoCart(CartBean cartBean) {
		return cartDAO.addIntoCart(cartBean);
	}

	@Override
	public int getUniqueID() {
		return uniqueId++;
	}

	@Override
	public List<CartBean> getAllProducts() {
		return cartDAO.getAllProducts();
	}

	@Override
	public double totalBill(int userId) {
		return cartDAO.totalBill(userId);
	}

	@Override
	public Long cardNumberValidator(String cardNumber) {
		Pattern pat = Pattern.compile("\\d{16}");
		Matcher mat = pat.matcher(cardNumber);
		if (mat.matches()) {
			return Long.parseLong(cardNumber);
		}
		return null;

	}// End of cardNumberValidator()

	@Override
	public int month(int month) {
		if (month < 1 && month > 12) {
			return month;
		}
		return 0;
	}

	@Override
	public Integer year(String year) {
		Pattern pat = Pattern.compile("\\d{4}");
		Matcher mat = pat.matcher(year);
		if (mat.matches()) {
			return Integer.parseInt(year);
		}
		return null;
	}

	@Override
	public Integer checkCVV(String cvv) {
		Pattern pat = Pattern.compile("\\d{3}");
		Matcher mat = pat.matcher(cvv);
		if (mat.matches()) {
			return Integer.parseInt(cvv);
		}
		return null;
	}

}// End of Class
