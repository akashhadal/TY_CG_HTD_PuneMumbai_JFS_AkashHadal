package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.MenuCardBean;
import com.capgemini.hotelmanagementsystem.exception.FetchNullListException;
import com.capgemini.hotelmanagementsystem.exception.UnableDeleteException;
import com.capgemini.hotelmanagementsystem.exception.UnableToAddException;
import com.capgemini.hotelmanagementsystem.exception.UnableToUpdateException;

@Repository
public class MenuCardDAOImplementation implements MenuCardDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	EntityManager entityManager;
	EntityTransaction entityTransaction;

	@Override
	public List<MenuCardBean> menuCard() {
		List<MenuCardBean> menuCartList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from MenuCardBean";
			Query query = entityManager.createQuery(jpql);
			menuCartList = query.getResultList();
		} catch (Exception e) {
			throw new FetchNullListException();
		}
		return menuCartList;
	}// end of menuCart()

	@Override
	public boolean addMenu(MenuCardBean menuCardBean) {
		boolean menuAdded = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(menuCardBean);
			entityTransaction.commit();
			menuAdded = true;
		} catch (Exception e) {
			throw new UnableToAddException();
		}
		entityManager.close();
		return menuAdded;
	}// end of addMenu()

	@Override
	public boolean deleteMenu(int foodId) {
		boolean menuDeleted = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			MenuCardBean menuCardBean = entityManager.find(MenuCardBean.class, foodId);
			entityManager.remove(menuCardBean);
			menuDeleted = true;
			entityTransaction.commit();
		} catch (Exception e) {
			throw new UnableDeleteException();
		}
		entityManager.close();
		return menuDeleted;
	}// end of deleteMenu()

	@Override
	public boolean updateMenu(MenuCardBean menuCardBean) {
		entityManager = entityManagerFactory.createEntityManager();
		MenuCardBean existingMenu = entityManager.find(MenuCardBean.class, menuCardBean.getFoodId());
		boolean menuUpdated = false;

		if (existingMenu != null) {
			String foodType = menuCardBean.getFoodType();
			if (foodType != null) {
				existingMenu.setFoodType(foodType);
			}
			String foodName = menuCardBean.getFoodName();
			if (foodName != null) {
				existingMenu.setFoodName(foodName);
			}

			double foodPrice = menuCardBean.getFoodPrice();
			if (foodPrice > 0) {
				existingMenu.setFoodPrice(foodPrice);
			}

			try {
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(existingMenu);
				entityTransaction.commit();
				menuUpdated = true;
			} catch (Exception e) {
				throw new UnableToUpdateException();
			}
			entityManager.close();
		}
		return menuUpdated;
	}// end of updatedRoom()

}
