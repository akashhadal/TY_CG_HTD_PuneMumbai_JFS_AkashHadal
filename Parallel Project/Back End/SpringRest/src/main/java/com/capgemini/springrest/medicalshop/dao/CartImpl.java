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
import com.capgemini.springrest.medicalshop.beans.LoginBean;
import com.capgemini.springrest.medicalshop.beans.OrderBean;
import com.capgemini.springrest.medicalshop.beans.Payment;
import com.capgemini.springrest.medicalshop.beans.ProductBean;


@Repository
public class CartImpl implements CartDao {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	
	Scanner sc = new Scanner(System.in);

	@Override
	public boolean addProduct(int uId, String getProductName) {
		String getUserName = null;
		double getPrice = 0;
		int getProductId = 0;
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();

		// Get user name
		String jpql = "from LoginBean where userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", uId);
		LoginBean userBean = (LoginBean) query.getSingleResult();
		getUserName = userBean.getUserName();

		// Get product Id and product price
		String jpql1 = "from ProductBean where productName= :productName";
		Query query1 = manager.createQuery(jpql1);
		query1.setParameter("productName", getProductName);
		ProductBean productBean = (ProductBean) query1.getSingleResult();
		getProductId = productBean.getProductId();
		getPrice = productBean.getPrice();

		// Insert into Cart
		boolean isAdded = false;

		CartBean cartBean = new CartBean();
		cartBean.setProductId(getProductId);
		cartBean.setPrice(getPrice);
		cartBean.setUserId(uId);
		cartBean.setProductName(getProductName);
		cartBean.setUserName(getUserName);

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
	public boolean deleteProduct(int cartId, int userId) {
		boolean isDeleted = false;
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();

		String jpql = "from CartBean where cartId= :cartId and userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("cartId", cartId);
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
	public Payment payment(int uId,String address) {
		String button1="y";
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
			
				String jpql1 = "from CartBean where UserId= :userId";
				Query query1 = manager.createQuery(jpql1);
				query1.setParameter("userId", uId);
				List<CartBean> cartBeans = query1.getResultList();
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
			
		} else {
			System.out.println("Transaction Failed");
		}

		return py;
	}// end of payment
	
	@Override
	public List<CartBean> getCart(int uId) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from CartBean where userId = :userId ";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", uId);

		List<CartBean> cartList = query.getResultList();
		return cartList;
	}
	
	@Override
	public boolean addOrder(OrderBean  orderBean) {
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

	@Override
	public List<OrderBean> viewOrder(int userId) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from OrderBean where userId = :userId ";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);

		List<OrderBean> list = query.getResultList();
		
		return list;
	}

	@Override
	public double totalBill(int userId) {
		
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		String jpql = "SELECT sum(price) from CartBean where userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);
		double total = (double) query.getSingleResult();
		
		return total;
	}

	

}// end of class
