package com.capgemini.medicalshopcollection.service;

import java.util.List;

import com.capgemini.medicalshopcollection.beans.CartBean;


public interface CartServices {
	public boolean addIntoCart(CartBean cartBean);
	public int getUniqueID();
	public List<CartBean> getAllProducts();
	public double totalBill(int userId);
	
	//Validators
	public Long cardNumberValidator(String cardNumber);
	public int month(int month);
	public Integer year(String year);
	public Integer checkCVV(String cvv);

}//End of Class
