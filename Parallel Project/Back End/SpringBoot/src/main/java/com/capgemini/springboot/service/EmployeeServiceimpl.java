package com.capgemini.springboot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springboot.beans.EmployeeInfoBean;
import com.capgemini.springboot.dao.EmployeeDAO;



@Service
public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public EmployeeInfoBean getEmployee(int empId) {

		return dao.getEmployee(empId);
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String pwd) {
		return dao.authenticate(empId, pwd);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.addEmployee(employeeInfoBean);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean updateData) {
		return dao.updateEmployee(updateData);
	}
	
	@Override
	public boolean deleteEmployee(int empId) {
		return dao.deleteEmployee(empId);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
