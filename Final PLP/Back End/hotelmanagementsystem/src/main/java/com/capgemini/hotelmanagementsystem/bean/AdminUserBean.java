package com.capgemini.hotelmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "user")
public class AdminUserBean {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "user_name")
	@NotBlank(message = "Name cannot be Blank...")
	@Pattern(regexp = "[a-zA-z]+([\\s][a-zA-z]+)*", message = "It Accepts only Characters")
	private String userName;

	@Column(name = "user_type")
	private String userType;

	@Column(name = "password")
	private String password;

	@Column(name = "user_email")
	@Email(message = "Email should be valid...")
	private String userEmail;

	@Column
	private String address;

	@Column
	@Pattern(regexp = "[a-zA-z]+([\\s][a-zA-z]+)*")
	private String nationality;

	@Column
	@Pattern(regexp = "[6-9]{1}[0-9]{9}")
	private String phoneNumber;
	
	@Column
	private int hotelId;

	// getter & setter
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


}// end of bean class
