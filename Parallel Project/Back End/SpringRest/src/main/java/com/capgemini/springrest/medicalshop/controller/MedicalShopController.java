 package com.capgemini.springrest.medicalshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrest.medicalshop.beans.AdminBean;
import com.capgemini.springrest.medicalshop.beans.LoginBean;
import com.capgemini.springrest.medicalshop.beans.MedicalResponse;
import com.capgemini.springrest.medicalshop.beans.UserBean;
import com.capgemini.springrest.medicalshop.service.MedicalShopService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicalShopController {

	@Autowired
	private MedicalShopService service;
	
	@PutMapping(path = "/registerUser1",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse Registration1(@RequestBody LoginBean bean) {
		boolean register=service.registerUser1(bean);
		MedicalResponse response=new MedicalResponse();
		if (register) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Users Registered.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Registration Failed........");
		}
		return response;
	}
	
	@PutMapping(path = "/registerUser",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse Registration(@RequestBody UserBean userBean) {
		boolean register=service.registerUser(userBean);
		MedicalResponse response=new MedicalResponse();
		if (register) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Users Registered.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Registration Failed........");
		}
		return response;
	}//End of Registration
	
	@PostMapping(path = "/updateUser",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse updateUser(@RequestBody UserBean bean) {
		boolean update=service.updateUserProfile(bean);
		MedicalResponse response=new MedicalResponse();
		if (update) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User Details Updated.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Update Failed........");
		}
		return response;
	}//End of updateUser()
	
	@DeleteMapping(path = "/deleteUser",produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse deleteUser(@RequestParam int userId) {
		boolean delete=service.removeUser(userId);
		MedicalResponse response=new MedicalResponse();
		if (delete) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User Deleted successfully.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Not Deleted........");
		}
		return response;
	}//End of deleteUser()
	
	@GetMapping(path = "/userLogin")
	public MedicalResponse UserLogin(@RequestParam String userName,@RequestParam String userPassword) {
		UserBean login=service.loginUser(userName, userPassword);
		MedicalResponse response=new MedicalResponse();
		if (login!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Users Logged in........");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Login Failed........");
		}
		return response;
	}//End of UserLogin
	
	
	@GetMapping(path = "/adminLogin")
	public MedicalResponse AdminLogin(@RequestParam String userName,@RequestParam String userPassword) {
		AdminBean login=service.loginAdmin(userName, userPassword);
		MedicalResponse response=new MedicalResponse();
		if (login!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Admin Logged in........");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Admin Login Failed........");
		}
		return response;
	}//End of AdminLogin
	
	@GetMapping(path = "/getAllUsers",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public MedicalResponse getAllUsers() {
		List<UserBean> list=service.getAllUser();
		MedicalResponse response=new MedicalResponse();
		if (list!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Users Data Found........");
			response.setUserList(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User data not Found........");
		}
		return response;
	}//End of getAllUsers()
	
}//End of RestController
