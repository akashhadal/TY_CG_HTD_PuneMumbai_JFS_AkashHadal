package com.capgemini.springrest.medicalshop.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class MedicalResponse {

	private int statusCode;
	private String message;
	private String description;
	private UserBean userBean;
	private List<UserBean> userList;
	private ProductBean productBean;
	private List<ProductBean> productList;
	private double price;
	private MessageBean messageBean;
	private List<MessageBean> messageBeans;
	private List<CartBean> cartBeans;
	
	//Getters and Setters
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	public List<UserBean> getUserList() {
		return userList;
	}
	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	public List<ProductBean> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductBean> productList) {
		this.productList = productList;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public MessageBean getMessageBean() {
		return messageBean;
	}
	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
	}
	public List<MessageBean> getMessageBeans() {
		return messageBeans;
	}
	public void setMessageBeans(List<MessageBean> messageBeans) {
		this.messageBeans = messageBeans;
	}
	public List<CartBean> getCartBeans() {
		return cartBeans;
	}
	public void setCartBeans(List<CartBean> cartBeans) {
		this.cartBeans = cartBeans;
	}

	
	
}//End of Response
