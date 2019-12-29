package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;
import com.capgemini.hotelmanagementsystem.bean.MenuCardBean;
import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.exception.FetchNullListException;
import com.capgemini.hotelmanagementsystem.exception.UnableDeleteException;
import com.capgemini.hotelmanagementsystem.exception.UnableToAddException;

@Repository
public class FoodDAOImplementation implements FoodDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	EntityManager entityManager;
	EntityTransaction entityTransaction;

	@Override
	public boolean foodOrder(int userId, int roomId, int foodId, int foodQuantity) {
		boolean foodOrder = false;
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		String jpql = "from AdminUserBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		AdminUserBean adminUserBean = null;
		try {
			adminUserBean = (AdminUserBean) query.getSingleResult();
		} catch (Exception e) {
			throw new UnableToAddException();
		}

		String jpql1 = "from MenuCardBean where foodId =: foodId";
		query = entityManager.createQuery(jpql1);
		query.setParameter("foodId", foodId);
		MenuCardBean menuCardBean = null;
		try {
			menuCardBean = (MenuCardBean) query.getSingleResult();
		} catch (Exception e) {
			throw new FetchNullListException();
		}

		String jpql2 = "from RoomBean where roomId=:roomId";
		query = entityManager.createQuery(jpql2);
		query.setParameter("roomId", roomId);
		RoomBean roomBean = null;
		try {
			roomBean = (RoomBean) query.getSingleResult();
		} catch (Exception e) {
			throw new FetchNullListException();
		}
		FoodOrderBean foodOrderBean = new FoodOrderBean();
		foodOrderBean.setUserId(userId);
		foodOrderBean.setUserName(adminUserBean.getUserName());
		foodOrderBean.setRoomId(roomId);
		foodOrderBean.setFoodId(foodId);
		foodOrderBean.setFoodName(menuCardBean.getFoodName());
		foodOrderBean.setFoodType(menuCardBean.getFoodType());
		foodOrderBean.setFoodPrice(menuCardBean.getFoodPrice());
		foodOrderBean.setFoodQuantity(foodQuantity);
		try {
			entityTransaction.begin();
			entityManager.persist(foodOrderBean);
			entityTransaction.commit();
			foodOrder = true;
		} catch (Exception e1) {
			throw new FetchNullListException();
		}
//		String jpql3 = "update MenuCardBean set foodQuantity =:userQuantity where foodId =:foodId";
//		query = entityManager.createQuery(jpql3);
//		query.setParameter("userQuantity", menuCardBean.getFoodQuantity() - foodQuantity);
//		query.setParameter("foodId", foodId);
//		entityTransaction.begin();
//		int result = query.executeUpdate();
//		entityTransaction.commit();
		return foodOrder;

	}// end of foodOrder()

	@Override
	public List<FoodOrderBean> orderedFoodList(int userId) {
		List<FoodOrderBean> foodList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from FoodOrderBean where userId=:userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			foodList = query.getResultList();
		} catch (Exception e) {
			throw new FetchNullListException();		}
		return foodList;
	}// end of bookingList()

	@Override
	public double foodBill(int userId) {
		double bill = 0;
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		String jpql = "select sum(foodPrice)*foodQuantity from FoodOrderBean where userId= :userId";
		try {
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			bill = (double) query.getSingleResult();
		} catch (Exception e) {
			throw new FetchNullListException();
		}
		return bill;
	}// end of payment

	@Override
	public boolean deleteOrder(int userId) {
		entityManager = entityManagerFactory.createEntityManager();
		//entityTransaction = entityManager.getTransaction();
		boolean deleteOrder = false;
		String jpql = "delete from FoodOrderBean where userId= :userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		try {
			//entityTransaction.begin();
			int result = query.executeUpdate();
			//entityTransaction.commit();
			deleteOrder = true;
		} catch (Exception e) {
			throw new UnableDeleteException();
		}
		return deleteOrder;

	}// end of deleteCart()

}
