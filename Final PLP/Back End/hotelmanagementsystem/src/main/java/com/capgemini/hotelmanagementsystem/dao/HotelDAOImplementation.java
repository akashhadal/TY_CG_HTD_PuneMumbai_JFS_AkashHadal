package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.exception.FetchNullListException;
import com.capgemini.hotelmanagementsystem.exception.UnableDeleteException;
import com.capgemini.hotelmanagementsystem.exception.UnableToAddException;
import com.capgemini.hotelmanagementsystem.exception.UnableToUpdateException;

@Repository
public class HotelDAOImplementation implements HotelDAO {
	@PersistenceUnit
	public EntityManagerFactory entityManagerFactory;

	EntityManager entityManager;
	EntityTransaction entityTransaction;

	@Override
	public boolean addHotel(HotelBean hotelBean){
		boolean addHotel = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(hotelBean);
			entityTransaction.commit();
			entityManager.close();
			addHotel = true;
		} catch (Exception e) {
			throw new UnableToAddException();
		}
		return addHotel;
	}

	@Override
	public boolean deleteHotel(int hotelId){
		boolean roomHotel = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			HotelBean hotelBean = entityManager.find(HotelBean.class, hotelId);
			entityManager.remove(hotelBean);
			entityTransaction.commit();
			roomHotel = true;
		} catch (Exception e) {
			throw new UnableDeleteException();
		}
		return roomHotel;
	}

	@Override
	public boolean updateHotel(HotelBean hotelBean) {
		entityManager = entityManagerFactory.createEntityManager();
		HotelBean existingHotelDetails = entityManager.find(HotelBean.class, hotelBean.getHotelId());
		boolean hotelUpdated = false;

		if (existingHotelDetails != null) {

			String hotelName = hotelBean.getHotelName();
			if (hotelName != null) {
				existingHotelDetails.setHotelName(hotelName);
			}

			String location = hotelBean.getLocation();
			if (location != null) {
				existingHotelDetails.setLocation(location);
			}

			int availableAcRoom = hotelBean.getAvailableAcRoom();
			if (availableAcRoom > 0) {
				existingHotelDetails.setAvailableAcRoom(availableAcRoom);
			}

			int availableNonAcRoom = hotelBean.getAvailableNonAcRoom();
			if (availableNonAcRoom > 0) {
				existingHotelDetails.setAvailableNonAcRoom(availableNonAcRoom);
			}
			try {
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(existingHotelDetails);
				entityTransaction.commit();
				hotelUpdated = true;
			} catch (Exception e) {
				throw new UnableToUpdateException();
			}
			entityManager.close();
		}
		return hotelUpdated;
	}

	@Override
	public List<HotelBean> getAllHotel(){
		List<HotelBean> hotelList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from HotelBean";
			Query query = entityManager.createQuery(jpql);
			hotelList = query.getResultList();
		} catch (Exception e) {
			throw new FetchNullListException();
		}
		return hotelList;
	}
	
	@Override
	public List<HotelBean> getAllHotelForManager(int hotelId) {
		List<HotelBean> hotelList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from HotelBean where hotelId=:hotelId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("hotelId", hotelId);
			hotelList = query.getResultList();
		} catch (Exception e) {
			throw new FetchNullListException();
		}
		return hotelList;
	}

	@Override
	public List<HotelBean> searchHotel(String location){
		List<HotelBean> hotelList = null;
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from HotelBean where location =:location";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("location", location);

		try {
			hotelList = query.getResultList();
		} catch (Exception e) {
			throw new FetchNullListException();
		}
		return hotelList;
	}

}
