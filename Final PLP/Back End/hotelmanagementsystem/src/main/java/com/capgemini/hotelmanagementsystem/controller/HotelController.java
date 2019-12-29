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

import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.HotelService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();

	@PostMapping("/addHotel")
	public HotelManagementResponse addHotel(@RequestBody HotelBean hotelBean) {
		boolean isHotelAdded = hotelService.addHotel(hotelBean);
		if (isHotelAdded) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Hotel Added Successfully");
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable to Add Hotel");
//		}
		return hotelManagementResponse;
	}// end of addHotel()

	@DeleteMapping("/removeHotel")
	public HotelManagementResponse removeHotel(@RequestParam int hotelId) {
		boolean removedHotel = hotelService.deleteHotel(hotelId);
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Removed Successfully");
		return hotelManagementResponse;
	}// end of removeHotel()

	@PostMapping(path="/updateHotel")
	public HotelManagementResponse updateHotel(@RequestBody HotelBean hotelBean) {
		boolean hotelUpdated = hotelService.updateHotel(hotelBean);
		if (hotelUpdated) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("update Successfully");
		}
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable to update");
//		}
		return hotelManagementResponse;
	}// end of updateHotel()

	@GetMapping("/getHotelList")
	public HotelManagementResponse getHotelList() {
		List<HotelBean> hotelList = hotelService.getAllHotel();
		if (hotelList != null && !hotelList.isEmpty()) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Hotel List");
			hotelManagementResponse.setHotelList(hotelList);
		}
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable to fetch Hotel List");
//		}
		return hotelManagementResponse;
	}// end of roomList()
	
	@GetMapping("/getHotelListForManager")
	public HotelManagementResponse getHotelListForManager(@RequestParam int hotelId) {
		List<HotelBean> hotelList = hotelService.getAllHotelForManager(hotelId);
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Hotel List of Manager");
			hotelManagementResponse.setHotelList(hotelList);
		return hotelManagementResponse;
	}// end of roomList()
	
	
	@GetMapping("/getHotelLocationList")
	public HotelManagementResponse getHotelLocationList(@RequestParam String location) {
		List<HotelBean> hotelList = hotelService.searchHotel(location);
		if (hotelList != null && !hotelList.isEmpty()) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Hotel List");
			hotelManagementResponse.setHotelList(hotelList);
		}
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable to fetch Hotel List");
//		}
		return hotelManagementResponse;
	}// end of roomList()

}
