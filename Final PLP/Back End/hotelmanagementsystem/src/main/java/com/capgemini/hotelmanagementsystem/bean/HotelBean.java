package com.capgemini.hotelmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "hotel")
public class HotelBean {
	@Id
	@Column(name = "hotel_id")
	private int hotelId;
	
	@Column(name = "hotel_name")
	private String hotelName;
	
	@Column(name = "location")
	@Pattern(regexp="[a-zA-z]+([\\\\s][a-zA-z]+)*")
	private String location;
	
	@Column(name = "available_ac")
	private int availableAcRoom;
	
	@Column(name = "available_non_ac")
	private int availableNonAcRoom;
	
	@Column
	private String image;
	// getter & setter

	public int getHotelId() {
		return hotelId;
	}

	public int getAvailableAcRoom() {
		return availableAcRoom;
	}

	public void setAvailableAcRoom(int availableAcRoom) {
		this.availableAcRoom = availableAcRoom;
	}

	public int getAvailableNonAcRoom() {
		return availableNonAcRoom;
	}

	public void setAvailableNonAcRoom(int availableNonAcRoom) {
		this.availableNonAcRoom = availableNonAcRoom;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	

}// end of bean class
