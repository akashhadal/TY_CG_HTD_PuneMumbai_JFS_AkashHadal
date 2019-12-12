 package com.capgemini.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.springboot.beans.EmployeeInfoBean;



@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public EmployeeInfoBean getEmployee(int empId) {

		EntityManager manager = emf.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		manager.close();

		return employeeInfoBean;
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String pwd) {

		EntityManager manager = emf.createEntityManager();
//		EmployeeInfoBean eib = manager.find(EmployeeInfoBean.class, empId);
//		if (eib!= null && pwd.equals(eib.getPassword())) {
//			return eib;
//		} else {
//			return null;
//		}

		String jpql = "from EmployeeInfoBean where empId=:empId and password=:pwd";
		Query query = manager.createQuery(jpql);
		query.setParameter("empId", empId);
		query.setParameter("pwd", pwd);

		EmployeeInfoBean employeeInfoBean = null;
		try {
			employeeInfoBean = (EmployeeInfoBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeInfoBean;

	}// end of authentication

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {

		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		boolean isAdded = false;

		try {
			trans.begin();
			manager.persist(employeeInfoBean);
			trans.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isAdded;

	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean updateData) {

		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		EmployeeInfoBean infoBean = manager.find(EmployeeInfoBean.class, updateData.getEmpId());
		boolean isUpdate = false;

		if (infoBean != null) {
			String name = updateData.getEmpName();
			if (name != null) {
				infoBean.setEmpName(name);
			}
			if (updateData.getAge() > 18) {
				infoBean.setAge(updateData.getAge());
			}
			double salary = updateData.getSalary();
			if (salary > 0) {
				infoBean.setSalary(salary);
			}
			long mobile = updateData.getMobile();
			if (mobile > 0) {
				infoBean.setMobile(mobile);
			}
			String designation = updateData.getDesignation();
			if (designation != null) {
				infoBean.setDesignation(designation);
			}
			char gender = updateData.getGender();
			if (gender == 'M' || gender == 'F' || gender == 'm' || gender == 'f') {
				infoBean.setGender(gender);
			}
			String password = updateData.getPassword();
			if (password != null) {
				infoBean.setPassword(password);
			}
		}

		try {
			trans.begin();
			manager.persist(infoBean);
			trans.commit();
			isUpdate = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isUpdate;

	}
	
	@Override
	public boolean deleteEmployee(int empId) {
		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			EmployeeInfoBean employeeInfoBean= entityManager.find(EmployeeInfoBean.class, empId);
			entityManager.remove(employeeInfoBean);
			tx.commit();
			isDeleted = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return isDeleted;
	}// End of deleteEmployee()

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from EmployeeInfoBean";
		Query query = manager.createQuery(jpql);
		
		List<EmployeeInfoBean> employeesList = null;
		try {
			employeesList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return employeesList;
		
	}// End of getAllEmployees()

}
