package com.capgemini.springrest.medicalshop.controller;

import java.util.List;

import javax.annotation.processing.Messager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrest.medicalshop.beans.MedicalResponse;
import com.capgemini.springrest.medicalshop.beans.MessageBean;
import com.capgemini.springrest.medicalshop.service.MessageService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageController {

@Autowired
private MessageService mService;

@GetMapping(path = "/getAdminMessage",produces = MediaType.APPLICATION_JSON_VALUE)
public MedicalResponse getAdminMessage() {
	List<MessageBean> messageBeans=mService.getMessage();
	MedicalResponse response=new MedicalResponse();
	if (messageBeans!=null) {
		response.setStatusCode(201);
		response.setMessage("Success");
		response.setMessageBeans(messageBeans);
		response.setDescription("User Queries acquired.......");
	} else {
		response.setStatusCode(401);
		response.setMessage("Failed");
		response.setDescription("User Queries Not Acquired........");
	}
	return response;
}//End of getAdminMessage()

@GetMapping(path = "/getUserMessage",produces = MediaType.APPLICATION_JSON_VALUE)
public MedicalResponse getUserMessage(@RequestParam int userId) {
	List<MessageBean> messageBeans=mService.getResponse(userId);
	MedicalResponse response=new MedicalResponse();
	if (messageBeans!=null) {
		response.setStatusCode(201);
		response.setMessage("Success");
		response.setMessageBeans(messageBeans);
		response.setDescription("User Queries acquired.......");
	} else {
		response.setStatusCode(401);
		response.setMessage("Failed");
		response.setDescription("User Queries Not Acquired........");
	}
	return response;
}//End of getUserMessage()

@PutMapping(path = "/adminResponse",produces = MediaType.APPLICATION_JSON_VALUE)
public MedicalResponse adminResponse(@RequestParam int userId,@RequestParam String message,@RequestParam String type) {
	boolean sent=mService.sendMessage(message, type, userId);
	MedicalResponse response=new MedicalResponse();
	if (sent) {
		response.setStatusCode(201);
		response.setMessage("Success");
		response.setDescription("User Queries Replied.......");
	} else {
		response.setStatusCode(401);
		response.setMessage("Failed");
		response.setDescription("User Queries Not Replied........");
	}
	return response;
}//End of adminResponse()
	
@PutMapping(path = "/userResponse")
public MedicalResponse userResponse(@RequestParam int userId,@RequestParam String message,@RequestParam String type) {
	boolean sent=mService.sendMessage(message, type, userId);
	MedicalResponse response=new MedicalResponse();
	if (sent) {
		response.setStatusCode(201);
		response.setMessage("Success");
		response.setDescription("User Queries Sent.......");
	} else {
		response.setStatusCode(401);
		response.setMessage("Failed");
		response.setDescription("User Queries Not Sent........");
	}
	return response;
}//End of userResponse()

	
}//End of MessageController()
