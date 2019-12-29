package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.dao.HotelDAO;

@Service
public class HotelServiceImplementation implements HotelService {
	@Autowired
	private HotelDAO hotelDAO;

	@Override
	public boolean addHotel(HotelBean hotelBean) {
		return hotelDAO.addHotel(hotelBean);
	}

	@Override
	public boolean deleteHotel(int hotelId) {
		return hotelDAO.deleteHotel(hotelId);
	}

	@Override
	public boolean updateHotel(HotelBean hotelBean) {
		return hotelDAO.updateHotel(hotelBean);
	}

	@Override
	public List<HotelBean> getAllHotel() {
		return hotelDAO.getAllHotel();
	}

	@Override
	public List<HotelBean> searchHotel(String location) {
		return hotelDAO.searchHotel(location);
	}

	@Override
	public List<HotelBean> getAllHotelForManager(int hotelId) {
		return hotelDAO.getAllHotelForManager(hotelId);
	}

}
