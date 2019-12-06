package com.capgemini.springrest.medicalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springrest.medicalshop.beans.MessageBean;
import com.capgemini.springrest.medicalshop.dao.MessageDao;

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
