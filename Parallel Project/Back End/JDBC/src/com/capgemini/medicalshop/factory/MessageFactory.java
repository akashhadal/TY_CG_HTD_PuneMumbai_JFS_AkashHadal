package com.capgemini.medicalshop.factory;

import com.capgemini.medicalshop.dao.MessageDao;
import com.capgemini.medicalshop.dao.MessageImpl;

public class MessageFactory {
	private MessageFactory() {
		
	}
	 public static MessageDao getMessageInstance() {
		 MessageDao messageDao = new MessageImpl();
		 return messageDao;
	 }

}
