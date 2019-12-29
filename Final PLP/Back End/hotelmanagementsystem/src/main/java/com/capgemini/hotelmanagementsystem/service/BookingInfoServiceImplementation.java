package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.dao.BookingInfoDAO;

@Service
public class BookingInfoServiceImplementation implements BookingInfoService {
	@Autowired
	BookingInfoDAO bookingInfoDAO;

	@Override
	public List<BookingInfoBean> bookedRoomList() {
		return bookingInfoDAO.bookedRoomList();
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		return bookingInfoDAO.cancelBooking(bookingId);
	}

	@Override
	public double getBill(BookingInfoBean bookingInfoBean) {
		return bookingInfoDAO.getBill(bookingInfoBean);
	}

	@Override
	public BookingInfoBean booking(BookingInfoBean bookingInfoBean) {
		return bookingInfoDAO.booking(bookingInfoBean);
	}

	@Override
	public List<BookingInfoBean> userBookedRooms(int userId) {
		return bookingInfoDAO.userBookedRooms(userId);
	}

}// end of service
