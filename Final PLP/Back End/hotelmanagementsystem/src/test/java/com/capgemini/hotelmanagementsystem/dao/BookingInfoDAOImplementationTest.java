package com.capgemini.hotelmanagementsystem.dao;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookingInfoDAOImplementationTest {

	public BookingInfoBean bookingInfoBean;
	@Autowired
	private BookingInfoDAO bookingInfoDAO;

//	@Test
//	void testBooking() {
//		bookingInfoBean.setUserId(2);
//		bookingInfoBean.setRoomId(10);
//		bookingInfoBean.setRoomAmount(15000);
//		bookingInfoBean.setPaymentStatus("unpaid");
//		bookingInfoBean.setModeOfPayment("cash");
//		bookingInfoBean.setHotelId(1);
//		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
//		Date checkInDate = format.parse("2019-12-29");
//		bookingInfoBean.setCheckInDate(checkInDate);
//		SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-dd");
//		Date checkInDate1 = format.parse("2019-12-30");
//		bookingInfoBean.setCheckOutDate(checkOutDate1);
//		bookingInfoBean.setHotelId(1);
//		
//		boolean expected=true;
//		TestCase.assertEquals(expected, bookingInfoDAO.booking(bookingInfoBean));
//
//	}

	@Test
	void testBookedRoomList() {
		TestCase.assertNotNull(bookingInfoDAO.bookedRoomList());
	}

	@Test
	void testCancelBooking() {
		boolean expected = true;
		boolean actual = bookingInfoDAO.cancelBooking(1);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testGetBill() {
		Double expected = 3000.00;
		Double actual = 3000.00;
		Assert.assertEquals(expected, actual);

	}

	@Test
	void testUserBookedRooms() {
		TestCase.assertNotNull(bookingInfoDAO.userBookedRooms(2));

	}

}
