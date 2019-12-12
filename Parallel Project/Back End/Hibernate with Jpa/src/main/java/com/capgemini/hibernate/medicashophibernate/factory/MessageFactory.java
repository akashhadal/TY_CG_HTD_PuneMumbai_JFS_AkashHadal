package com.capgemini.hibernate.medicashophibernate.factory;

import com.capgemini.hibernate.medicashophibernate.dao.MessageDao;
import com.capgemini.hibernate.medicashophibernate.dao.MessageImpl;

public class MessageFactory {
	private MessageFactory() {
		
	}
	 public static MessageDao getMessageInstance() {
		 MessageDao dao = new MessageImpl();
		 return dao;
	 }

}
