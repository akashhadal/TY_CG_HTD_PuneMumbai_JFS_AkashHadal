	package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.exception.EmailAlreadyExistException;
import com.capgemini.hotelmanagementsystem.exception.FetchNullListException;
import com.capgemini.hotelmanagementsystem.exception.InvalidLoginCredentials;
import com.capgemini.hotelmanagementsystem.exception.InvalidPasswordException;
import com.capgemini.hotelmanagementsystem.exception.UnableDeleteException;
import com.capgemini.hotelmanagementsystem.exception.UnableRegisterException;
import com.capgemini.hotelmanagementsystem.exception.UnableToUpdateException;

@Repository
public class AdminUserDAOImplementation implements AdminUserDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;


	@Override
	public AdminUserBean login(String userEmail, String password) {
		AdminUserBean adminUserBean = null;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from AdminUserBean where userEmail = :userEmail and password = :password   ";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userEmail", userEmail);
			query.setParameter("password", password);
			adminUserBean = (AdminUserBean) query.getSingleResult();

		} catch (Exception e) {
			throw new InvalidLoginCredentials();
		}
		return adminUserBean;
	}

	@Override
	public boolean userRegister(AdminUserBean adminUserBean){
		boolean isRegister = false;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();

		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(adminUserBean);
			entityTransaction.commit();
			isRegister = true;
			entityManager.close();
		} catch (Exception e) {
			System.out.println("Exception");
			throw new UnableRegisterException();
		}
		return isRegister;
	}
	
	@Override
	public List<AdminUserBean> getAllUsers() {
		List<AdminUserBean> userList = null;
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		try {
			entityManager = entityManagerFactory.createEntityManager();
			String userType = "user";
			String jpql = "FROM AdminUserBean where userType=:userType";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userType", userType);
			userList = query.getResultList();
			entityManager.close();

		} catch (Exception e) {

			throw new FetchNullListException();
		}
		return userList;
		// End of showAllUsers()
	}

	@Override
	public List<AdminUserBean> getAllEmployee(){
		List<AdminUserBean> employeeList = null;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String userType = "employee";
			String jpql = "FROM AdminUserBean where userType=:userType";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userType", userType);
			employeeList = query.getResultList();
			entityManager.close();

		} catch (Exception e) {

			throw new FetchNullListException();
		}
		return employeeList;
	}

	@Override
	public boolean deleteEmployee(int userId){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		boolean isRemove = false;
		try {
			
			AdminUserBean adminUserBean = entityManager.find(AdminUserBean.class, userId);
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(adminUserBean);
			entityTransaction.commit();
			isRemove = true;
		} catch (Exception e) {
			throw new UnableDeleteException();
		}
		return isRemove;
	}

	@Override
	public boolean deleteUser(int userId) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		boolean isRemove = false;
		try {
			
			AdminUserBean adminUserBean = entityManager.find(AdminUserBean.class, userId);
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(adminUserBean);
			entityTransaction.commit();
			isRemove = true;
		} catch (Exception e) {
			throw new UnableDeleteException();
		}
		return isRemove;
	}

	@Override
	public AdminUserBean userProfile(int userId) {

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String jpql = "from AdminUserBean where userId=: userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		AdminUserBean adminUserBean=null;
		try {
		 adminUserBean = (AdminUserBean) query.getSingleResult();
		} catch (Exception e) {
			throw new FetchNullListException();
		}
		return adminUserBean;
	}

	@Override
	public boolean emailPresent(String email) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		boolean unique = false;
		try {
			String jpql = "FROM AdminUserBean";
			Query query = entityManager.createQuery(jpql);
			List<AdminUserBean> userList = (List<AdminUserBean>) query.getResultList();
			for (AdminUserBean userBean : userList) {
				if (email.equals(userBean.getUserEmail())) {
					unique = true;
					return unique;
				}
			}	
		} catch (Exception e) {
			throw new EmailAlreadyExistException();
		}
		return unique;
	
	}
	
	@Override
	public boolean passwordChecker(String userEmail,String password) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		boolean unique = false;
		try {
			String jpql = "FROM AdminUserBean where userEmail=:userEmail";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userEmail", userEmail);
			AdminUserBean userList = (AdminUserBean) query.getSingleResult();
				if (password.equals(userList.getPassword())) {
					unique = true;
					return unique;
			}
		} catch (Exception e) {
			throw new InvalidPasswordException();
		}
		return unique;
	
	}

	@Override
	public List<AdminUserBean> managerList() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		List<AdminUserBean> managerList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String userType="manager";
			String jpql = "FROM AdminUserBean  where userType =: userType";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userType", userType);
		
			managerList = query.getResultList();
			entityManager.close();

		} catch (Exception e) {
			throw new FetchNullListException();
		}
		return managerList;
	}

	@Override
	public boolean deleteManager(int userId){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		boolean isRemove = false;
		try {
			
			AdminUserBean adminUserBean = entityManager.find(AdminUserBean.class, userId);
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(adminUserBean);
			entityTransaction.commit();
			isRemove = true;
		} catch (Exception e) {
			throw new UnableDeleteException();
		}
		return isRemove;
	}

	@Override
	public boolean updateProfile(AdminUserBean adminUserBean) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		AdminUserBean existingUser = entityManager.find(AdminUserBean.class, adminUserBean.getUserId());
		boolean profileUpdated = false;
		if (existingUser != null) {

			String userName = adminUserBean.getUserName();
			if (userName != null) {
				existingUser.setUserName(userName);
			}

			String email = adminUserBean.getUserEmail();
			if (email != null) {
				existingUser.setUserEmail(email);
			}

			String address = adminUserBean.getAddress();
			if (address != null) {
				existingUser.setAddress(address);
			}

			String phoneNumber = adminUserBean.getPhoneNumber();
			if (phoneNumber!= null) {
				existingUser.setPhoneNumber(phoneNumber);
			}
			String nationality = adminUserBean.getNationality();
			if (nationality!= null) {
				existingUser.setNationality(nationality);;
			}
			try {
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(existingUser);
				entityTransaction.commit();
				profileUpdated = true;
			} catch (Exception e) {
				throw new UnableToUpdateException();
			}
			entityManager.close();
		}
		return profileUpdated;
	}


	

	

}
