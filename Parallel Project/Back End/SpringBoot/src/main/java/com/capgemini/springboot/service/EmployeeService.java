package com.capgemini.springboot.service;

import java.util.List;

import com.capgemini.springboot.beans.EmployeeInfoBean;




public interface EmployeeService {

	public EmployeeInfoBean getEmployee(int empId);

	public EmployeeInfoBean authenticate(int empId, String pwd);

	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);

	public boolean updateEmployee(EmployeeInfoBean updateData);

	public boolean deleteEmployee(int empId);

	public List<EmployeeInfoBean> getAllEmployees();
}// End of SErvice
