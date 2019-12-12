package com.capgemini.medicalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalshop.beans.CartBean;
import com.capgemini.medicalshop.beans.OrderBean;
import com.capgemini.medicalshop.beans.Payment;
import com.capgemini.medicalshop.dao.CartDao;


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
	public Payment payment(int uId,String address) {
		return cdao.payment(uId,address);
	}

	@Override
	public List<CartBean> getCart(int uId) {
		return cdao.getCart(uId);
	}

	@Override
	public boolean addOrder(OrderBean orderBean) {
		return cdao.addOrder(orderBean);
	}

	@Override
	public List<OrderBean> viewOrder(int userId) {
		return cdao.viewOrder(userId);
	}



	
}//End of CartServiceImpli()
