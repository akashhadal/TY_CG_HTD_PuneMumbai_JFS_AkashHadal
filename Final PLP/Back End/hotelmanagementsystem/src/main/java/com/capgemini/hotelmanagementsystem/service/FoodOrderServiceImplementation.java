package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;
import com.capgemini.hotelmanagementsystem.dao.FoodDAO;
@Service
public class FoodOrderServiceImplementation implements FoodOrderService {
	@Autowired
	private FoodDAO foodDAO;

	@Override
	public boolean foodOrder(int userId, int roomId, int foodId, int foodQuantity) {
		return foodDAO.foodOrder(userId, roomId, foodId, foodQuantity);
	}

	@Override
	public List<FoodOrderBean> orderedFoodList(int userId) {
		return foodDAO.orderedFoodList(userId);
	}

	@Override
	public double foodBill(int userId) {
		return foodDAO.foodBill(userId);
	}

	@Override
	public boolean deleteOrder(int userId) {
		return foodDAO.deleteOrder(userId);
	}

}
