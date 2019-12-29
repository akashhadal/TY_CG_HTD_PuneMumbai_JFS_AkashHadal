package com.capgemini.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagementsystem.bean.MenuCardBean;
import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.MenuCardService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class MenuCardController {
	@Autowired
	private MenuCardService menuCardService;
	HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();

	@GetMapping("/menuCard")
	public HotelManagementResponse getMenuCard() {
		List<MenuCardBean> listMenuCard = menuCardService.menuCard();
		if (listMenuCard != null) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("SuccessfullY");
			hotelManagementResponse.setDescription("Menu Cart List");
			hotelManagementResponse.setListMenuCard(listMenuCard);
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable to fetch");
//		}
		return hotelManagementResponse;
	}// end of getMenuCard

	@PostMapping("/addMenu")
	public HotelManagementResponse addMenu(@RequestBody MenuCardBean menuCardBean) {
		boolean menuAdded = menuCardService.addMenu(menuCardBean);
		if (menuAdded) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Successfull");
			hotelManagementResponse.setDescription("Menu Added Successfully");
//			hotelManagementResponse.setMenuCardBean(menuCardBean);
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable to add Menu");
//		}
		return hotelManagementResponse;
	}// end of addMenu()

	@DeleteMapping("/deleteMenu")
	public HotelManagementResponse deleteMenu(@RequestParam int foodId) {
			boolean menuDeleted = menuCardService.deleteMenu(foodId);
			if (menuDeleted) {
				hotelManagementResponse.setStatusCode(201);
				hotelManagementResponse.setMessage("Successfull");
				hotelManagementResponse.setDescription("Menu deleted Successfully");
			} 
//			else {
//				hotelManagementResponse.setStatusCode(401);
//				hotelManagementResponse.setMessage("Failed");
//				hotelManagementResponse.setDescription("Unable to delete Menu");
//			}
			return hotelManagementResponse;
	}// end of deleteMenu()

	@PostMapping("/updateMenu")
	public HotelManagementResponse updateMenu(@RequestBody MenuCardBean menuCardBean) {
		boolean menuUpdated = menuCardService.updateMenu(menuCardBean);
		if (menuUpdated) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Successfull");
			hotelManagementResponse.setDescription("Menu Updated Successfully");
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable to Update Menu");
//		}
		return hotelManagementResponse;
	}// end of updateMenu()
}
