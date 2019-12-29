package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.RoomBean;

public interface RoomService {
	// To add Room in Hotel
			public boolean addRoom(RoomBean roomBean);

			//To Get List of All Rooms in Hotel
			public List<RoomBean> getRoom(int hotelId);
			
			//To Remove Room from Hotel
			public boolean removeRoom(int roomId);
			
			//To Update Details of Room
			public boolean updateRoom(RoomBean roomBean);
			
			//To Get List of All Rooms in Hotel
			public List<RoomBean> getRoomManager();
}
