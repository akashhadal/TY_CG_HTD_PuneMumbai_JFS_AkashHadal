package com.capgemini.hotelmanagementsystem.dao;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.RoomBean;

import junit.framework.TestCase;


@RunWith(SpringRunner.class)
@SpringBootTest
class RoomDAOImplementationTest {

	public RoomBean roomBean;
	@Autowired
	private RoomDAO roomDAO;

	@Test
	void testAddRoom() {
		roomBean = new RoomBean();
		roomBean.setRoomRent(4000.000);
		roomBean.setRoomType("3");
		roomBean.setRoomCapacity(3);
		roomBean.setRoomFacility("AC");
		roomBean.setRoomStatus("UnAvailable");
		roomBean.setHotelId(2);
		boolean expected = true;
		boolean actual = roomDAO.addRoom(roomBean);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testGetRoom() {
		TestCase.assertNotNull(roomDAO.getRoom(1));
	}

	@Test
	void testRemoveRoom() {
		boolean expected = true;
		boolean actual = roomDAO.removeRoom(12);
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testUpdateRoom() {
		roomBean = new RoomBean();
		roomBean.setRoomId(11);
		roomBean.setRoomRent(3000.000);
		roomBean.setRoomType("1");
		roomBean.setRoomCapacity(21);
		roomBean.setRoomFacility("NON AC");
		roomBean.setRoomStatus("Available");
		roomBean.setHotelId(1);
		boolean expected = true;
		boolean actual = roomDAO.updateRoom(roomBean);
		TestCase.assertEquals(expected, actual);
	}

}
