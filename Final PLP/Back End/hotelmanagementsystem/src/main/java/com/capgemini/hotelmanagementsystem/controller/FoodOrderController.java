package com.capgemini.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;
import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.FoodOrderService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class FoodOrderController {
	@Autowired
	private FoodOrderService foodOrderService;

	HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();

	@PostMapping("/orderFood")
	public HotelManagementResponse orderFood(@RequestParam int userId, @RequestParam int roomId,
			@RequestParam int foodId, @RequestParam int foodQuantity) {
		boolean foodOrdered = foodOrderService.foodOrder(userId, roomId, foodId, foodQuantity);
		if (foodOrdered) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Your Order Placed successfully");
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Unable to place order");
		}
		return hotelManagementResponse;
	}// end of orderFood()

	@GetMapping("/foodList")
	public HotelManagementResponse foodList(@RequestParam int userId) {
		List<FoodOrderBean> foodList = foodOrderService.orderedFoodList(userId);
		if (foodList != null) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setFoodList(foodList);
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("You have not ordered something");
		}
		return hotelManagementResponse;
	}// end of foodList()

	@GetMapping("/getFoodBill")
	public HotelManagementResponse getBill(@RequestParam int userId) {
		double bill = foodOrderService.foodBill(userId);
		if (bill > 0) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setFoodBill(bill);
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("You have not ordered something");
		}
		return hotelManagementResponse;
	}// end of getBill()

	@DeleteMapping("/deleteOrder")
	public HotelManagementResponse deleteOrder(@RequestParam int userId) {
		boolean deleteOrder = foodOrderService.deleteOrder(userId);
		if (deleteOrder) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Order Deleted Successfully");
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("You have not ordered something");
		}
		return hotelManagementResponse;
	}
}
