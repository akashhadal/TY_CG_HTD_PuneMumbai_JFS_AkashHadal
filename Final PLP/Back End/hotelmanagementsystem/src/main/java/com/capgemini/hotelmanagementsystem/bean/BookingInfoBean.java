package com.capgemini.hotelmanagementsystem.bean;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "booking_info")
public class BookingInfoBean {
	@Id
	@Column(name = "booking_id")
	private int bookingId;
	@Column(name = "room_id")
	private int roomId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "amount")
	private double roomAmount;
	@Column(name = "payment_status")
	private String paymentStatus;
	@Column(name = "mode_of_payment")
	private String modeOfPayment;
	
	@Column(name = "checkin_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate checkInDate;
	
	@Column(name = "checkout_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate checkOutDate;
	
	@Column(name = "hotel_id")
	private int hotelId;
	
	// Getter and Setter
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getRoomAmount() {
		return roomAmount;
	}
	public void setRoomAmount(double roomAmount) {
		this.roomAmount = roomAmount;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public LocalDate getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
}// end of BookingInfoBean
