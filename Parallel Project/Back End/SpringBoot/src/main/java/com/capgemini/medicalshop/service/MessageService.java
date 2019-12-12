package com.capgemini.medicalshop.service;

import java.util.List;

import com.capgemini.medicalshop.beans.MessageBean;



public interface MessageService {

	public boolean sendMessage(String message, String type, int uId);

	public List<MessageBean> getMessage();

	public boolean sendResponse(String message, String type, int uId);

	public List<MessageBean> getResponse(int userId);
	
}
