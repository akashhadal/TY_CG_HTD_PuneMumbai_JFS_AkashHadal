package com.capgemini.hotelmanagementsystem.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.exception.FetchNullListException;
import com.capgemini.hotelmanagementsystem.exception.UnableDeleteException;

@Repository
public class BookingInfoDAOImplementation implements BookingInfoDAO {
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	EntityTransaction entityTransaction;

	BookingInfoBean bookingInfoBean;

	@Override
	public BookingInfoBean booking(BookingInfoBean bookingInfoBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		RoomBean roomBean;
		double daysBetween;
		double days;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			bookingInfoBean.setCheckInDate(bookingInfoBean.getCheckInDate());
			bookingInfoBean.setCheckOutDate(bookingInfoBean.getCheckOutDate());
			String roomQuery = "from RoomBean where roomId=:roomId";
			Query query = entityManager.createQuery(roomQuery);
			query.setParameter("roomId", bookingInfoBean.getRoomId());
			roomBean = (RoomBean) query.getSingleResult();
			System.err.println("Facility "+roomBean.getRoomFacility());
			bookingInfoBean.setHotelId(roomBean.getHotelId());
			daysBetween = 0;
			days=0;
			daysBetween = ChronoUnit.DAYS.between(bookingInfoBean.getCheckInDate(), bookingInfoBean.getCheckOutDate());
			if (daysBetween == 0) {
				days = 1;
			}else {
				days = ChronoUnit.DAYS.between(bookingInfoBean.getCheckInDate(), bookingInfoBean.getCheckOutDate());
			}
			double bill = days * roomBean.getRoomRent();
			bookingInfoBean.setRoomAmount(bill);
			bookingInfoBean.setRoomId(bookingInfoBean.getRoomId());
			bookingInfoBean.setHotelId(bookingInfoBean.getHotelId());
			bookingInfoBean.setUserId(bookingInfoBean.getUserId());
			bookingInfoBean.setRoomAmount(bill);
			bookingInfoBean.setCheckInDate(bookingInfoBean.getCheckInDate());
			bookingInfoBean.setCheckOutDate(bookingInfoBean.getCheckOutDate());
			int roomQuantity = 1;
			if (roomBean.getRoomFacility().equals("NON-AC")) {
				System.err.println("Facility NON-AC WALA");
				HotelBean hotelBean = entityManager.find(HotelBean.class, bookingInfoBean.getHotelId());
				hotelBean.setAvailableNonAcRoom(hotelBean.getAvailableNonAcRoom() - roomQuantity);
			} else  {
				System.err.println("Facility AC wala");
				HotelBean hotelBean = entityManager.find(HotelBean.class, bookingInfoBean.getHotelId());
				hotelBean.setAvailableAcRoom(hotelBean.getAvailableAcRoom() - roomQuantity);
			}
			entityTransaction.begin();
			entityManager.persist(bookingInfoBean);
			entityTransaction.commit();

		} catch (Exception e) {
			throw new FetchNullListException();

		}
		entityManager.close();
		return bookingInfoBean;
	}// end of booking()

	@Override
	public List<BookingInfoBean> bookedRoomList() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<BookingInfoBean> bookedList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from BookingInfoBean";
			Query query = entityManager.createQuery(jpql);
			bookedList = query.getResultList();
		} catch (Exception e) {
			throw new FetchNullListException();
		}
		return bookedList;
	}// end of bookingList()

	@Override
	public boolean cancelBooking(int bookingId) {
		boolean canceled = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		BookingInfoBean bookingInfoBean = entityManager.find(BookingInfoBean.class, bookingId);
		try {
			// entityTransaction.begin();
			RoomBean roomBean = entityManager.find(RoomBean.class, bookingInfoBean.getRoomId());
			int roomQuantity = 1;
			if (roomBean.getRoomFacility() == "AC") {
				HotelBean hotelBean = entityManager.find(HotelBean.class, bookingInfoBean.getHotelId());
				hotelBean.setAvailableAcRoom(hotelBean.getAvailableAcRoom() + roomQuantity);
			} else {
				HotelBean hotelBean = entityManager.find(HotelBean.class, bookingInfoBean.getHotelId());
				hotelBean.setAvailableNonAcRoom(hotelBean.getAvailableNonAcRoom() + roomQuantity);
			}

			entityTransaction.begin();
			entityManager.remove(bookingInfoBean);
			entityTransaction.commit();
			canceled = true;
		} catch (Exception e) {
			throw new UnableDeleteException();
		}
		return canceled;
	}// end of cancelBooking()

	@Override
	public double getBill(BookingInfoBean bookingInfoBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		double totalBill = 0;
		try {
			double daysBetween= 0;
			double days=0;
			LocalDate checkInDate = bookingInfoBean.getCheckInDate();
			LocalDate checkOutDate = bookingInfoBean.getCheckOutDate();
			daysBetween = ChronoUnit.DAYS.between(bookingInfoBean.getCheckInDate(), bookingInfoBean.getCheckOutDate());
			if (daysBetween == 0) {
				days = 1;
			}else {
				days = ChronoUnit.DAYS.between(bookingInfoBean.getCheckInDate(), bookingInfoBean.getCheckOutDate());
			}
			String roomQuery = "from RoomBean where roomId=: roomId";
			Query query6 = entityManager.createQuery(roomQuery);
			query6.setParameter("roomId", bookingInfoBean.getRoomId());
			RoomBean roomBean = (RoomBean) query6.getSingleResult();
			totalBill = days * roomBean.getRoomRent();
			bookingInfoBean.setPaymentStatus("Paid");
		} catch (Exception e) {
			throw new FetchNullListException();
		}
		return totalBill;
	}

	@Override
	public List<BookingInfoBean> userBookedRooms(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from BookingInfoBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		List<BookingInfoBean> userBookedList = null;
		try {
			userBookedList = query.getResultList();
		} catch (Exception e) {
			throw new FetchNullListException();
		}
		return userBookedList;
	}// end of userBookedRooms()

}// end of implementation
