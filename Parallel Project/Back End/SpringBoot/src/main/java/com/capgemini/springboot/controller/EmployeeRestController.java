package com.capgemini.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.beans.EmployeeInfoBean;
import com.capgemini.springboot.beans.EmployeeResponse;
import com.capgemini.springboot.service.EmployeeService;


//@Controller
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;

	@GetMapping(path = "/getEmployee/{employeeId}",
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	// @ResponseBody
	public EmployeeResponse getEmployee(@PathVariable("employeeId") int empId, ModelMap modelMap) {
		EmployeeInfoBean employeeInfoBean=service.getEmployee(empId);
		EmployeeResponse response=new EmployeeResponse();
		
		if (employeeInfoBean!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Found Succefully......");	
			response.setEmployeeInfoBean(employeeInfoBean);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee not Found........");
		}
		return response;
	}// End of getEmployee()

	// @ResponseBody
	@PutMapping(path = "/addEmployee", 
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		boolean isAdded=service.addEmployee(employeeInfoBean);
		
		EmployeeResponse response=new EmployeeResponse();
		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Added Succefully......");	
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee not Added........");
		}
		return response;
		
	}// End of addEmployee()

	@DeleteMapping(path = "/deleteEmployee/{employeeId}",
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	// @ResponseBody
	public EmployeeResponse deleteEmployee(@PathVariable("employeeId") int empId) {
		boolean isDeleted=service.deleteEmployee(empId);
		EmployeeResponse response=new EmployeeResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Deleted Succefully......");	
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee not Deleted........");
		}
		return response;
	}// end of deleteEmployee()

	@PostMapping(path = "/updateEmployee",
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		boolean isUpdated=service.updateEmployee(employeeInfoBean);
		EmployeeResponse response=new EmployeeResponse();
		if (isUpdated) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Updated Succefully......");	
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee not Updated........");
		}
		return response;
	}// End of updateEmployee()

	@GetMapping(path = "/getAllEmployee", 
			produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getAllImployee() {
		List<EmployeeInfoBean> employeeInfoBean=service.getAllEmployees();
EmployeeResponse response=new EmployeeResponse();
		
		if (employeeInfoBean!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Data Found Succefully......");	
			response.setEmployeeslist(employeeInfoBean);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee data not Found........");
		}
		return response;
	}// End of getAllEmployees()

}// End of Controller
