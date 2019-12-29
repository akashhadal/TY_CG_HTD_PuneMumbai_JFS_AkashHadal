package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;

public interface BookingInfoDAO {

	// To get List of all Booked Rooms
	public List<BookingInfoBean> bookedRoomList();

	// To cancel the booking
	public boolean cancelBooking(int bookingId);

	// To get Bill
	public double getBill(BookingInfoBean bookingInfoBean);

	// To Book Room
	public BookingInfoBean booking(BookingInfoBean bookingInfoBean);

	// To Display Users Booked Rooms
	public List<BookingInfoBean> userBookedRooms(int userId);
}// end of interface
