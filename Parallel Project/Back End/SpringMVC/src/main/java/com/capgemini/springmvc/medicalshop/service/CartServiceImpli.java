package com.capgemini.springmvc.medicalshop.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springmvc.medicalshop.beans.CartBean;
import com.capgemini.springmvc.medicalshop.beans.Payment;
import com.capgemini.springmvc.medicalshop.dao.CartDao;

@Service
public class CartServiceImpli implements CartService {

	@Autowired
	private CartDao dao;
	
	@Override
	public boolean addProduct(int uId, String getProductName) {
		return dao.addProduct(uId, getProductName);
	}

	@Override
	public boolean deleteProduct(String pName, int userId) {
		return dao.deleteProduct(pName, userId);
	}

	@Override
	public Payment payment(int uId, String button) {
		return dao.payment(uId, button);
	}

	@Override
	public List<CartBean> cart(int userId) {
		return dao.cart(userId);
	}

}
