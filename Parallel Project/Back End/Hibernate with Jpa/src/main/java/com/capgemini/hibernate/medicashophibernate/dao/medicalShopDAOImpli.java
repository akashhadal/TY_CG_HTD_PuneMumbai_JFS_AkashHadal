package com.capgemini.hibernate.medicashophibernate.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.hibernate.medicashophibernate.beans.AdminBean;
import com.capgemini.hibernate.medicashophibernate.beans.ProductBean;
import com.capgemini.hibernate.medicashophibernate.beans.UserBean;


public class medicalShopDAOImpli implements medicalShopDAO {

	Scanner sc=new Scanner(System.in);
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("medicalPersistence");

	
	@Override
	public UserBean registerUser(int uId, String name, String email, String password) {
		
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		boolean isAdded = false;
		
		UserBean userBean=new UserBean();
		userBean.setUserId(uId);
		userBean.setUserName(name);
		userBean.setUserEmail(email);
		userBean.setUserPassword(password);

		try {
			trans.begin();
			manager.persist(userBean);
			trans.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return userBean;
	}

	@Override
	public UserBean loginUser(String name, String password) {
		int userId = 0;
		EntityManager manager = emf.createEntityManager();

		String jpql = "from UserBean where userName= :userName and userPassword= :userPassword";
		Query query = manager.createQuery(jpql);
		query.setParameter("userName", name);
		query.setParameter("userPassword", password);

		UserBean userBean = null;
		try {
			userBean = (UserBean) query.getSingleResult();
			userId=userBean.getUserId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBean;
	}

	@Override
	public List<UserBean> getAllUser() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from UserBean";
		Query query = manager.createQuery(jpql);
		
		List<UserBean> userList = null;
		try {
			userList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public UserBean updateUserProfile(int uId, String name,String email,String password) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		UserBean userBean=new UserBean();
		userBean.setUserId(uId);
		userBean.setUserName(name);
		userBean.setUserEmail(email);
		userBean.setUserPassword(password);
		UserBean bean = manager.find(UserBean.class, uId);
		boolean isUpdate = false;

		if (bean != null) {
			String name1 = userBean.getUserName();
			if (name != null) {
				bean.setUserName(name1);
			}
			int id=userBean.getUserId();
			if (id >0) {
				bean.setUserId(id);
			}
			String email1=userBean.getUserEmail();
			if (email!=null) {
				bean.setUserEmail(email1);
			}	
			String password1=userBean.getUserPassword();
			if (password!=null) {
				bean.setUserPassword(password1);
			}
		}

		try {
			trans.begin();
			manager.persist(bean);
			trans.commit();
			isUpdate = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return bean;
	}

	@Override
	public int loginAdmin(String name, String password) {
		int userId = 0;
		EntityManager manager = emf.createEntityManager();

		String jpql = "from AdminBean where adminName= :adminName and adminPassword= :adminPassword";
		Query query = manager.createQuery(jpql);
		query.setParameter("adminName", name);
		query.setParameter("adminPassword", password);

		AdminBean adminBean = null;
		try {
			adminBean = (AdminBean) query.getSingleResult();
			userId=adminBean.getAdminId();
		} catch (Exception e) {
			System.out.println("Wrong Email or Password");
		}
		return userId;
	}

	@Override
	public boolean removeUser(int userId) {
	
		EntityManager manager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction trans = manager.getTransaction();
			trans.begin();
			UserBean bean= manager.find(UserBean.class, userId);
			manager.remove(bean);
			trans.commit();
			isDeleted = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isDeleted;
	}

	@Override
	public UserBean getUser(int userId) {
		
		EntityManager manager=emf.createEntityManager();
		String jpql = "from UserBean where userId= :userId";
		Query query=manager.createQuery(jpql);
		query.setParameter("userId", userId);
		
		UserBean bean=null;
		try {
			bean=(UserBean) query.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean;
		
	}//End of getUser

}// End of Class
