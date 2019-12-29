package com.capgemini.hotelmanagementsystem.dao;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.HotelBean;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
class HotelDAOImplementationTest {


	public HotelBean hotelBean;

	@Autowired
	private HotelDAO hotelDAO;

	@BeforeEach
	public void createObject() {
		hotelBean = new HotelBean();
	}

	@Test
	void testAddHotel() {
		hotelBean = new HotelBean();
		hotelBean.setHotelName("Aghgfa");
		hotelBean.setLocation("Mumbai");
		hotelBean.setAvailableAcRoom(30);
		hotelBean.setAvailableNonAcRoom(40);
		boolean expected = true;
		boolean actual = hotelDAO.addHotel(hotelBean);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testDeleteHotel() {
		boolean expected = true;
		boolean actual = hotelDAO.deleteHotel(15);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testUpdateHotel() {
		hotelBean = new HotelBean();
		hotelBean.setHotelId(8);
		hotelBean.setHotelName(" Hotel Arcgh gfa");
		hotelBean.setLocation("Mumbai");
		hotelBean.setAvailableAcRoom(80);
		hotelBean.setAvailableNonAcRoom(40);
		boolean expected = true;
		boolean actual = hotelDAO.updateHotel(hotelBean);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testGetAllHotel() {
		TestCase.assertNotNull(hotelDAO.getAllHotel());
	}

	@Test
	void testSearchHotel() {
		TestCase.assertNotNull(hotelDAO.searchHotel("Mumbai"));
	}

}
