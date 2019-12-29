package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;

public interface FoodDAO {

	// To order Food
	public boolean foodOrder(int userId, int roomId, int foodId, int foodQuantity);

	// To display ordered food
	public List<FoodOrderBean> orderedFoodList(int userId);

	// To Pay Bill
	public double foodBill(int userId);

	// To Delete order after Payment
	public boolean deleteOrder(int userId);
}
