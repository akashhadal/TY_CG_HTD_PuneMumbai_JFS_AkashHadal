package com.capgemini.medicalshop.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalshop.beans.MessageBean;



@Repository
public class MessageImpl implements MessageDao {

	
	Scanner sc = new Scanner(System.in);

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public boolean sendMessage(String message, String type, int userId) {
		boolean isSent=false;
		EntityManager manager=emf.createEntityManager();
		MessageBean bean=new MessageBean();
		bean.setUserId(userId);
		bean.setType(type);
		bean.setMessage(message);
		try {
			EntityTransaction trans=manager.getTransaction();
			trans.begin();
			manager.persist(bean);
			trans.commit();
			isSent=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSent;
	}// end of send message

	@Override
	public List<MessageBean> getMessage() {
		
		EntityManager manager=emf.createEntityManager();
		String type = "Question";
		String jpql = "from MessageBean where type= :type";
		Query query = manager.createQuery(jpql);
		query.setParameter("type", type);
		List<MessageBean> bean=null;
		try {
			bean=query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public boolean sendResponse(String message, String type, int uId) {
		boolean isSent=false;
		EntityManager manager=emf.createEntityManager();
		MessageBean bean=new MessageBean();
		bean.setUserId(uId);
		bean.setType(type);
		bean.setMessage(message);
		try {
			EntityTransaction trans=manager.getTransaction();
			trans.begin();
			manager.persist(bean);
			trans.commit();
			isSent=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSent;
	}

	@Override
	public List<MessageBean> getResponse(int userId) {
		EntityManager manager=emf.createEntityManager();
		String type = "Answer";
		String jpql = "from MessageBean where type= :type and userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("type", type);
		query.setParameter("userId", userId);
		List<MessageBean> bean=null;
		try {
			bean=query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
		
	}

}// end of class
