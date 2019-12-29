package com.capgemini.hotelmanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.bean.MenuCardBean;
import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.exception.UnableDeleteException;
import com.capgemini.hotelmanagementsystem.service.AdminUserService;
import com.capgemini.hotelmanagementsystem.service.BookingInfoService;
import com.capgemini.hotelmanagementsystem.service.FoodOrderService;
import com.capgemini.hotelmanagementsystem.service.HotelService;
import com.capgemini.hotelmanagementsystem.service.MenuCardService;
import com.capgemini.hotelmanagementsystem.service.RoomService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelmanagementsystemApplicationTests {
	
	// Test with valid data
	
	
	
	// Test with valid data

		public AdminUserBean adminUserBean;
		public BookingInfoBean bookingInfoBean;
		public HotelBean hotelBean;
		public RoomBean roomBean;
		public MenuCardBean menuCardBean;
		public FoodOrderBean foodOrderBean;

		@Autowired
		private AdminUserService adminUserService;
		@Autowired
		private BookingInfoService bookingInfoService;
		@Autowired
		private HotelService hotelService;
		@Autowired
		private RoomService roomService;
		@Autowired
		private MenuCardService menuCardService;
		@Autowired
		private FoodOrderService foodOrderService;

		@BeforeEach
		public void createObject() {
			adminUserBean = new AdminUserBean();
			bookingInfoBean = new BookingInfoBean();
			hotelBean = new HotelBean();
			roomBean = new RoomBean();
			menuCardBean = new MenuCardBean();
			foodOrderBean = new FoodOrderBean();
		}

		// admin login
		@Test
		public void testValidAdminLogin() {
			String userEmail = "suraj@gmail.com";
			String password = "Suraj@95";
			adminUserBean = adminUserService.login(userEmail, password);
			String expected = "admin";
			String actual = adminUserBean.getUserType();

			Assert.assertEquals(expected, actual);
		}

		// employee login
		@Test
		public void testValidEmployeeLogin() {
			String userEmail = "sakshi@gmail.com";
			String password = "sakshi@123";
			adminUserBean = adminUserService.login(userEmail, password);
			String expected = "employee";
			String actual = adminUserBean.getUserType();

			Assert.assertEquals(expected, actual);
		}

		// user login
		@Test
		public void testValidUserLogin() {
			String userEmail = "mayuri@gmail.com";
			String password = "Mayuri@123";
			adminUserBean = adminUserService.login(userEmail, password);
			String expected = "user";
			String actual = adminUserBean.getUserType();

			Assert.assertEquals(expected, actual);
		}

//		// manager login
		@Test
		public void testValidManagerLogin() {
			String userEmail = "manager@gmail.com";
			String password = "Manager@123";
			adminUserBean = adminUserService.login(userEmail, password);
			String expected = "manager";
			String actual = adminUserBean.getUserType();

			Assert.assertEquals(expected, actual);

		}

		@Test
		public void testManagerList() {
			TestCase.assertNotNull(adminUserService.managerList());
		}

		// user register with valid data
		@Test
		public void userRegister() {
			adminUserBean = new AdminUserBean();
			adminUserBean.setUserName("Aishwarya syrve");
			adminUserBean.setUserType("user");
			adminUserBean.setPassword("Aish@123");
			adminUserBean.setUserEmail("aish@gmail.com");
			adminUserBean.setNationality("Indian");
			adminUserBean.setAddress("Pune");
			adminUserBean.setPhoneNumber("8529637412");

			boolean expected = true;
			boolean actual = adminUserService.userRegister(adminUserBean);
			Assert.assertEquals(expected, actual);

			TestCase.assertEquals(false, adminUserService.userRegister(adminUserBean));
		}

		@Test
		public void testGetAllUser() {
			TestCase.assertNotNull(adminUserService.getAllUsers());
		}

		@Test
		public void testGetAllEmployee() {
			TestCase.assertNotNull(adminUserService.getAllEmployee());
		}

		@Test
		public void testDeleteUser() {
			adminUserBean = new AdminUserBean();
			TestCase.assertEquals(true, adminUserService.deleteUser(7));
		}

		@Test(expected = UnableDeleteException.class)
		public void testDeleteEmployee() {
			adminUserBean = new AdminUserBean();
			TestCase.assertEquals(false, adminUserService.deleteEmployee(3));
		}

		// update UserProfile by user

	//********************** Junit On Hotel Funtionality*****************

		@Test
		public void testAddHotel() {
			hotelBean = new HotelBean();
			hotelBean.setHotelName("trdytf");
			hotelBean.setLocation("Mumbai");
			hotelBean.setAvailableAcRoom(30);
			hotelBean.setAvailableNonAcRoom(40);
			boolean expected = true;
			boolean actual = hotelService.addHotel(hotelBean);
			Assert.assertEquals(expected, actual);
		}

		@Test
		public void testUpdateHotel() {
			hotelBean = new HotelBean();
			hotelBean.setHotelId(1);
			hotelBean.setHotelName(" Hotel Arfa");
			hotelBean.setLocation("Mumbai");
			hotelBean.setAvailableAcRoom(40);
			hotelBean.setAvailableNonAcRoom(40);
			boolean expected = true;
			boolean actual = hotelService.updateHotel(hotelBean);
			Assert.assertEquals(expected, actual);
		}

		@Test
		public void testGetHotelList() {
			TestCase.assertNotNull(hotelService.getAllHotel());
		}

		@Test
		public void testSerachList() {
			TestCase.assertNotNull(hotelService.searchHotel("Mumbai"));
		}

		@Test(expected = UnableDeleteException.class)
		public void testRemoveHotel() {
			boolean expected = true;
			boolean actual = hotelService.deleteHotel(23);
			Assert.assertEquals(expected, actual);
		}

		// ********************** Junit On Room Funtionality*****************

		@Test
		public void testAddRoom() {
			roomBean = new RoomBean();
			roomBean.setRoomRent(4000.000);
			roomBean.setRoomType("2");
			roomBean.setRoomCapacity(2);
			roomBean.setRoomFacility("AC");
			roomBean.setRoomStatus("Available");
			roomBean.setHotelId(2);
			boolean expected = true;
			boolean actual = roomService.addRoom(roomBean);
			Assert.assertEquals(expected, actual);
		}

		@Test
		public void testGetBookedRoomList() {
			TestCase.assertNotNull(bookingInfoService.bookedRoomList());
		}

		@Test
		public void testUpdateRoom() {
			roomBean = new RoomBean();
			roomBean.setRoomId(1);
			roomBean.setRoomRent(3000.000);
			roomBean.setRoomType("1");
			roomBean.setRoomCapacity(21);
			roomBean.setRoomFacility("AC");
			roomBean.setRoomStatus("Unavailable");
			roomBean.setHotelId(2);
			boolean expected = true;
			boolean actual = roomService.updateRoom(roomBean);
			TestCase.assertEquals(expected, actual);
		}

		@Test(expected = UnableDeleteException.class)
		public void testRemoveRoom() {
			boolean expected = true;
			boolean actual = roomService.removeRoom(13);
			Assert.assertEquals(expected, actual);
		}

		// ********************** Junit On Booked Room Funtionality*****************

//		@Test  
//		public void testBookingRoom() {
//			bookingInfoBean= new BookingInfoBean();
//			bookingInfoBean.setRoomId(7);
//			bookingInfoBean.setUserId(4);
//			bookingInfoBean.setRoomAmount(4000);
//			bookingInfoBean.setPaymentStatus("Paid");
//			bookingInfoBean.setModeOfPayment("cash");
//			bookingInfoBean.setCheckInDate(22-12-2019);
//			bookingInfoBean.setCheckOutDate(2019-12-24);
//			bookingInfoBean.setHotelId(1);
//			boolean expected = true;
//			boolean actual = bookingInfoService.bookingInfo(bookingInfoBean, hotelId, roomId);
//			TestCase.assertEquals(expected, actual);
//		}

		@Test(expected = UnableDeleteException.class)
		public void testCancelBooking() {
			boolean expected = true;
			boolean actual = bookingInfoService.cancelBooking(1);
			Assert.assertEquals(expected, actual);
		}

}
