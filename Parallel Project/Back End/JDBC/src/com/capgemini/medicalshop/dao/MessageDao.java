package com.capgemini.medicalshop.dao;

import com.capgemini.medicalshop.bean.MessageBean;

public interface MessageDao {

	public MessageBean sendMessage(String message, String type, int uId);

	public MessageBean getMessage();

	public MessageBean sendResponse(String message, String type, int uId);

	public MessageBean getResponse(int uId);

}
