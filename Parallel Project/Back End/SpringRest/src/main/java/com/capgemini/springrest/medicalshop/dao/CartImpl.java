package com.capgemini.springrest.medicalshop.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.springrest.medicalshop.beans.CartBean;
import com.capgemini.springrest.medicalshop.beans.OrderBean;
import com.capgemini.springrest.medicalshop.beans.Payment;
import com.capgemini.springrest.medicalshop.beans.ProductBean;
import com.capgemini.springrest.medicalshop.beans.UserBean;

@Repository
public class CartImpl implements CartDao {

	@PersistenceUnit
	private EntityManagerFactory emf;

	Scanner sc = new Scanner(System.in);

	@Override
	public boolean addProduct(int uId, String getProductName) {
		String getuserName = null;
		// String getProductName = null;
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
		// System.out.println("enter product name ");
		// getProductName = sc.nextLine();
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
	public Payment payment(int uId,String button,String address) {
		String button1=button;
		Payment py=new Payment();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		String jpql = "SELECT sum(price) from CartBean where userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", uId);
		double total = (double) query.getSingleResult();

		if (total > 0) {
			System.out.println("Total Amount to pay is " + total);
			py.setPrice(total);
			System.out.println("Proceed to pay");
			if (button1.equalsIgnoreCase("y")) {
				String jpql1 = "from CartBean where UserId= :userId";
				Query query1 = manager.createQuery(jpql1);
				query1.setParameter("userId", uId);
				List<CartBean> cartBeans = query1.getResultList();
				py.setPaymentStatus("fail");
				OrderBean orderBean=new OrderBean();
				for (CartBean cartBean : cartBeans) {
					orderBean.setOrderId(cartBean.getCartId());
					orderBean.setUserId(cartBean.getUserId());
					orderBean.setAddress(address);
					orderBean.setPrice(cartBean.getPrice());
					orderBean.setProductId(cartBean.getProductId());
					orderBean.setUserName(cartBean.getUserName());
					orderBean.setProductName(cartBean.getProductName());
					boolean order=addOrder(orderBean);
					if (order) {
						trans.begin();
						manager.remove(cartBean);
						trans.commit();	
						py.setPaymentStatus("done");
					} else {
						System.out.println("Order Failed");
					}
				}
				System.out.println("Transaction Completed");
			} else if (button.equalsIgnoreCase("n")) {
				System.out.println("Transaction Failed");
				py.setPaymentStatus("fail");
			}
		} else {
			System.out.println("Transaction Failed");
		}

		return py;
	}// end of payment

	@Override
	public List<CartBean> cart(int userId) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from CartBean where userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);
		
		List<CartBean> list = null;
		try {
			list = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean addOrder(OrderBean orderBean) {
		boolean isAdded=false;
		EntityManager manager=emf.createEntityManager();
		EntityTransaction trans=manager.getTransaction();
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
