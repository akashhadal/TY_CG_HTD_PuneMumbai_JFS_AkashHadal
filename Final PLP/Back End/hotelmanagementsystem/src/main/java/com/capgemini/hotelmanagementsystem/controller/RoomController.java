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

import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.RoomService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class RoomController {
	@Autowired
	public RoomService roomService;
	
	HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();

	@PostMapping("/addRoom")
	public HotelManagementResponse addRoom(@RequestBody RoomBean roomBean) {
		boolean isRoomAdded = roomService.addRoom(roomBean);
		if (isRoomAdded) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Room Added Successfully");
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable to Add Room");
//		}
		return hotelManagementResponse;
	}// end of addRoom()

	@GetMapping("/getRoomList")
	public HotelManagementResponse getRoomList(@RequestParam int hotelId) {
		List<RoomBean> roomList = roomService.getRoom(hotelId);
		if (roomList != null && !roomList.isEmpty()) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Room List");
			hotelManagementResponse.setRoomList(roomList);
		}
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable to fetch Room List");
//		}
		return hotelManagementResponse;
	}// end of roomList()

	@DeleteMapping("/removeRoom")
	public HotelManagementResponse removeRoom(@RequestParam int roomId) {
		boolean removedRoom = roomService.removeRoom(roomId);
		if(removedRoom) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Removed Successfully");
		}
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable to remove");
//		}
		return hotelManagementResponse;
	}// end of removeRoom()
	
	@PostMapping("/updateRoom")
	public HotelManagementResponse updateRoom(@RequestBody RoomBean roomBean) {
		boolean roomUpdated = roomService.updateRoom(roomBean);
		if(roomUpdated) {
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
	}// end of updateRoom()
	
}
