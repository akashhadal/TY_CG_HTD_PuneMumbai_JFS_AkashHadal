package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.HotelBean;

public interface HotelService {
	//add hotel by admin 
		public boolean addHotel(HotelBean hotelBean);

		//delete hotel by admin
		public boolean deleteHotel(int hotelId);

		// update hotel by admin
		public boolean updateHotel(HotelBean hotelBean);

		// get all hotel list
		public List<HotelBean> getAllHotel();
		
		// get all hotel list for Manager
		public List<HotelBean> getAllHotelForManager(int hotelId);
		
		// serach hotel by location
		public List<HotelBean> searchHotel(String location);
}
