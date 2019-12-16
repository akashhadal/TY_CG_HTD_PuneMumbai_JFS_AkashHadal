package com.capgemini.medicalshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalshop.beans.AdminBean;
import com.capgemini.medicalshop.beans.LoginBean;
import com.capgemini.medicalshop.beans.MedicalResponse;
import com.capgemini.medicalshop.beans.UserBean;
import com.capgemini.medicalshop.service.MedicalShopService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicalShopController {

	@Autowired
	private MedicalShopService service;
	//**************************Front End*********************************************
	@PutMapping(path = "/registerUser1",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse Registration(@RequestBody LoginBean bean) {
		boolean register=service.registerUser(bean);
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
	
	@PostMapping(path = "/login")
	public MedicalResponse Login(@RequestBody LoginBean loginBean) {
		LoginBean login=service.login(loginBean.getUserEmail(), loginBean.getUserPassword());
		MedicalResponse response=new MedicalResponse();
		if (login!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setLoginBean(login);
			response.setDescription("Users Logged in........");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Login Failed........");
		}
		return response;
	}//End of UserLogin
	//*****************************Back ENd******************************************
	
	
	@PostMapping(path = "/updateUser")
	public MedicalResponse updateUser(@RequestBody LoginBean bean) {
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
	
	@DeleteMapping(path = "/deleteUser/{userId}")
	public MedicalResponse deleteUser(@PathVariable("userId") int userId) {
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
	
		
		@GetMapping(path = "/userProfile/{userId}")
		public MedicalResponse UserProfile(@PathVariable("userId") int userId) {
			List<LoginBean> login=service.userProfile(userId);
			MedicalResponse response=new MedicalResponse();
			if (login!=null) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setLoginBeans(login);
				response.setDescription("Users Profile Retrived........");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed");
				response.setDescription("Users Profile Not Retrived........");
			}
			return response;
	}//End of UserLogin
	
	
	@GetMapping(path = "/getAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse getAllUsers() {
		List<LoginBean> list=service.getAllUser();
		MedicalResponse response=new MedicalResponse();
		if (list!=null) {
			/*
			 * response.setStatusCode(201); response.setMessage("Success");
			 * response.setDescription("Users Data Found........");
			 */
			response.setLoginBeans(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User data not Found........");
		}
		return response;
	}//End of getAllUsers()
	
}//End of RestController
