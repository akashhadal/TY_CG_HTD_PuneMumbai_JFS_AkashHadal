package com.capgemini.medicalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalshop.beans.MessageBean;
import com.capgemini.medicalshop.dao.MessageDao;


@Service 
public class MessageServiceImpli implements MessageService {

	@Autowired
	private MessageDao dao;
	
	@Override
	public boolean sendMessage(String message, String type, int uId) {
		return dao.sendMessage(message, type, uId);
	}

	@Override
	public List<MessageBean> getMessage() {
		return dao.getMessage();
	}

	@Override
	public boolean sendResponse(String message, String type, int uId) {
		return dao.sendResponse(message, type, uId);
	}

	@Override
	public List<MessageBean> getResponse(int userId) {
		return dao.getResponse(userId);
	}

}
