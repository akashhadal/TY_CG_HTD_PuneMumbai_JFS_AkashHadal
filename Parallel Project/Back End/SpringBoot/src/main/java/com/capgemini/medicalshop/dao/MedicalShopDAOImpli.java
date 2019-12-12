package com.capgemini.medicalshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalshop.beans.AdminBean;
import com.capgemini.medicalshop.beans.LoginBean;
import com.capgemini.medicalshop.beans.UserBean;



@Repository
public class MedicalShopDAOImpli implements medicalShopDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean registerUser(UserBean userBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		boolean isAdded = false;
		

		try {
			trans.begin();
			manager.persist(userBean);
			trans.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isAdded;
	}//End of Register User()

	@Override
	public UserBean loginUser(String name, String password) {
		EntityManager manager = emf.createEntityManager();

		String jpql = "from UserBean where userName= :userName and userPassword= :userPassword";
		Query query = manager.createQuery(jpql);
		query.setParameter("userName", name);
		query.setParameter("userPassword", password);

		// EmployeeInfoBean employeeInfoBean = null;
		UserBean userBean = null;
		try {
			userBean = (UserBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBean;
	}// End of LoginUser()

	@Override
	public AdminBean loginAdmin(String name, String password) {
		EntityManager manager = emf.createEntityManager();

		String jpql = "from AdminBean where adminName= :adminName and adminPassword= :adminPassword";
		Query query = manager.createQuery(jpql);
		query.setParameter("adminName", name);
		query.setParameter("adminPassword", password);

		// EmployeeInfoBean employeeInfoBean = null;
		AdminBean adminBean = null;
		try {
			adminBean = (AdminBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminBean;
	}// End of loginAdmin()

	@Override
	public List<LoginBean> getAllUser() {
		String role="User";
		EntityManager manager = emf.createEntityManager();
		String jpql = "from LoginBean where role= :role";
		Query query = manager.createQuery(jpql);
		query.setParameter("role", role);
		
		List<LoginBean> userList = null;
		try {
			userList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}//End of getAllUsers()

	@Override
	public boolean updateUserProfile(LoginBean loginBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		LoginBean bean = manager.find(LoginBean.class, loginBean.getUserId());
		boolean isUpdate = false;

		if (bean != null) {
			String name = loginBean.getUserName();
			if (name != null) {
				bean.setUserName(name);
			}
			int id=loginBean.getUserId();
			if (id >0) {
				bean.setUserId(id);
			}
			String email=loginBean.getUserEmail();
			if (email!=null) {
				bean.setUserEmail(email);
			}	
			String password=loginBean.getUserPassword();
			if (password!=null) {
				bean.setUserPassword(password);
			}
		}

		try {
			trans.begin();
			manager.persist(bean);
			trans.commit();
			isUpdate = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isUpdate;
	}

	@Override
	public boolean removeUser(int userId) {
		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			LoginBean userBean= entityManager.find(LoginBean.class, userId);
			entityManager.remove(userBean);
			tx.commit();
			isDeleted = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return isDeleted;
	}//End of removeUser()

	@Override
	public boolean registerUser1(LoginBean loginBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		boolean isAdded = false;
		
		try {
			trans.begin();
			manager.persist(loginBean);
			trans.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isAdded;
	}

	@Override
	public LoginBean login(String name, String password) {
		EntityManager manager = emf.createEntityManager();

		String jpql = "from LoginBean where userName= :userName and userPassword= :userPassword";
		Query query = manager.createQuery(jpql);
		query.setParameter("userName", name);
		query.setParameter("userPassword", password);

		LoginBean user = null;
		try {
			user = (LoginBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<LoginBean> userProfile(int userId) {
		
		EntityManager manager = emf.createEntityManager();
		String jpql = "from LoginBean where userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);
		
		List<LoginBean> userList = null;
		try {
			userList =  query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}

}//End of Impli()
