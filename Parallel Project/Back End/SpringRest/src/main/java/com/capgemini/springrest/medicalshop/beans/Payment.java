package com.capgemini.springrest.medicalshop.beans;

public class Payment {

	private double price;
	private String paymentStatus;
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}//End of Payment
