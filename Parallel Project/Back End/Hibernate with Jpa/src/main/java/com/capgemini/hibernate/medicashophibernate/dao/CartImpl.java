package com.capgemini.hibernate.medicashophibernate.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.hibernate.medicashophibernate.beans.CartBean;
import com.capgemini.hibernate.medicashophibernate.beans.OrderBean;
import com.capgemini.hibernate.medicashophibernate.beans.ProductBean;
import com.capgemini.hibernate.medicashophibernate.beans.UserBean;

public class CartImpl implements CartDao {

	FileReader reader = null;
	Properties prop = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	Scanner sc = new Scanner(System.in);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("medicalPersistence");

	@Override
	public boolean addProduct(int uId) {
		String getuserName = null;
		String getProductName = null;
		double getPrice = 0;
		int getproductId = 0;
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();

		// Get user name
		String jpql = "from UserBean where userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", uId);
		UserBean userBean = (UserBean) query.getSingleResult();
		getuserName = userBean.getUserName();

		// Get product Id and product price
		System.out.println("enter product name ");
		getProductName = sc.nextLine();
		String jpql1 = "from ProductBean where productName= :productName";
		Query query1 = manager.createQuery(jpql1);
		query1.setParameter("productName", getProductName);
		ProductBean productBean = (ProductBean) query1.getSingleResult();
		getproductId = productBean.getProductId();
		getPrice = productBean.getPrice();

		// Insert into Cart
		boolean isAdded = false;

		CartBean cartBean = new CartBean();
		cartBean.setProductId(getproductId);
		cartBean.setPrice(getPrice);
		cartBean.setUserId(uId);
		cartBean.setProductName(getProductName);
		cartBean.setUserName(getuserName);

		try {
			trans.begin();
			manager.persist(cartBean);
			trans.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}// end of addproduct()

	@Override
	public boolean deleteProduct(String pName, int userId) {
		boolean isDeleted = false;
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();

		String jpql = "from CartBean where productName= :productName and userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("productName", pName);
		query.setParameter("userId", userId);
		CartBean cartBean = (CartBean) query.getSingleResult();
		try {
			trans.begin();
			manager.remove(cartBean);
			trans.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isDeleted;
	}// end of deleteproduct()

	@Override
	public double payment(int uId) {

		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		String jpql = "SELECT sum(price) from CartBean where userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", uId);
		double total = (double) query.getSingleResult();

		if (total > 0) {
			System.out.println("Total Amount to pay is " + total);
			if (total>0) {
				System.out.println("Enter Address");
				String address=sc.nextLine();
				String jpql1 = "from CartBean where UserId= :userId";
				Query query1 = manager.createQuery(jpql1);
				query1.setParameter("userId", uId);
				List<CartBean> cartBeans = query1.getResultList();
				OrderBean orderBean=new OrderBean();
				for (CartBean cartBean : cartBeans) {
					orderBean.setUserId(cartBean.getUserId());
					orderBean.setAddress(address);
					orderBean.setPrice(cartBean.getPrice());
					orderBean.setProductId(cartBean.getProductId());
					orderBean.setUserName(cartBean.getUserName());
					orderBean.setProductName(cartBean.getProductName());
					boolean order=insertIntoCart(orderBean);
					if (order) {
						trans.begin();
						manager.remove(cartBean);
						trans.commit();	
					} else {
						System.out.println("Order Failed");
					}
				}
				System.out.println("Transaction Completed");
			} else {
				System.out.println("Transaction Failed");
				System.exit(0);
			}
		} else {
			System.out.println("Transaction Failed");
		}

		return total;
	}// end of payment

	@Override
	public List<OrderBean> orderBeans(int userId) {
		EntityManager manager=emf.createEntityManager();
		String jpql = "from OrderBean where userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);
		
		List<OrderBean> orderList = null;
		try {
			orderList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return orderList;
	}

	@Override
	public boolean insertIntoCart(OrderBean orderBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		boolean isAdded=false;
		try {
			trans.begin();
			manager.persist(orderBean);
			trans.commit();
			isAdded=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}

}// end of class
