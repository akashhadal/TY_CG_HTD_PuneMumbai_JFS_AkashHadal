package com.capgemini.springrest.medicalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springrest.medicalshop.beans.CartBean;
import com.capgemini.springrest.medicalshop.beans.OrderBean;
import com.capgemini.springrest.medicalshop.beans.Payment;
import com.capgemini.springrest.medicalshop.dao.CartDao;

@Service
public class CartServiceImpli implements CartService {

	@Autowired
	private CartDao cdao;
	
	@Override
	public boolean addProduct(int uId, String getProductName) {
		return cdao.addProduct(uId,getProductName);
	}

	@Override
	public boolean deleteProduct(String pName, int userId) {
		return cdao.deleteProduct(pName, userId);
	}

	@Override
	public Payment payment(int uId,String button,String address) {
		return cdao.payment(uId,button,address);
	}

	@Override
	public List<CartBean> cart(int userId) {
		return cdao.cart(userId);
	}

	
	
}//End of CartServiceImpli()
