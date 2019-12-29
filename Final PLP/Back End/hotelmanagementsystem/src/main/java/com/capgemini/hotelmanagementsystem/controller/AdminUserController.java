package com.capgemini.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.AdminUserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class AdminUserController {
	@Autowired
	private AdminUserService adminUserService;

	@PostMapping(path = "/login")
	public HotelManagementResponse adminUserLogin(@RequestParam String userEmail, @RequestParam String password) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (adminUserService.passwordChecker(userEmail, password)) {
			AdminUserBean adminUserBean = adminUserService.login(userEmail, password);
			
				hotelManagementResponse.setStatusCode(201);
				hotelManagementResponse.setMessage("Success");
				hotelManagementResponse.setDescription("Log In Scussessfully!!!");
				hotelManagementResponse.setAdminUserBean(adminUserBean);

		}
		return hotelManagementResponse;		

	}// End of adminLogin()

	@PostMapping(path = "/userRegister")
	public HotelManagementResponse userRegister(@RequestBody AdminUserBean adminUserBean) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		String email = adminUserBean.getUserEmail();
		boolean isEmailPresent = adminUserService.emailPresent(email);
		if (!isEmailPresent) {
			boolean registerUser = adminUserService.userRegister(adminUserBean);
			if (registerUser) {
				hotelManagementResponse.setStatusCode(201);
				hotelManagementResponse.setMessage("Success");
				hotelManagementResponse.setDescription("User Registered Successfully.......");
			}
			return hotelManagementResponse;
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Email Already Exists........");
			return hotelManagementResponse;
		}
	}

	@GetMapping(path = "/getAllUsers", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public HotelManagementResponse getAllUsers() {
		List<AdminUserBean> userList = adminUserService.getAllUsers();
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("This Are All User");
			hotelManagementResponse.setUserList(userList);
		
		return hotelManagementResponse;
	}// End of getAllUsers()

	@GetMapping(path = "/getAllEmployees", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public HotelManagementResponse getAllEmployees() {
		List<AdminUserBean> userList = adminUserService.getAllEmployee();
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("This Are All User");
			hotelManagementResponse.setUserList(userList);
		
		return hotelManagementResponse;
	}// End of getAllUsers()

	@DeleteMapping(path = "/deleteUser")
	public HotelManagementResponse deleteUser(@RequestParam int userId) {
		 adminUserService.deleteUser(userId);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("User Deleted successfully.......");
		
		return hotelManagementResponse;
	} // End of deleteUser()

	@DeleteMapping(path = "/deleteEmployee")
	public HotelManagementResponse deleteEmployee(@RequestParam int userId) {
		adminUserService.deleteEmployee(userId);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Employee Deleted successfully.......");

		return hotelManagementResponse;
	} // End of deleteUser()

	@GetMapping(path = "/userProfile")
	public HotelManagementResponse userProfile(@RequestParam int userId) {
		AdminUserBean userProfile = adminUserService.userProfile(userId);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();

		hotelManagementResponse.setStatusCode(201);
		hotelManagementResponse.setMessage("Success");
		hotelManagementResponse.setDescription("User Profile Update Scussessfully!!");
		hotelManagementResponse.setAdminUserBean(userProfile);
		return hotelManagementResponse;
	}// End of userProfile()

	@GetMapping(path = "/getAllManager")
	public HotelManagementResponse getAllManager() {
		List<AdminUserBean> getAllManager = adminUserService.managerList();
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setGetAllManager(getAllManager);
		
		return hotelManagementResponse;
	}// End of getUserProfile()

	@DeleteMapping(path = "/deleteManager")
	public HotelManagementResponse deleteManager(@RequestParam int userId) {
		 adminUserService.deleteManager(userId);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Manager Deleted successfully.......");
		return hotelManagementResponse;
	} // End of deleteManager()
	
	@PostMapping("/updateProfile")
	public HotelManagementResponse updateProfile(@RequestBody AdminUserBean adminUserBean) {
		 adminUserService.updateProfile(adminUserBean);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(201);
		hotelManagementResponse.setMessage("Success");
		hotelManagementResponse.setDescription("User Profile Updated successfully.......");
		return hotelManagementResponse;
	}

}
