 package com.capgemini.hibernate.medicashophibernate.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.hibernate.medicashophibernate.beans.ProductBean;


public class ProductImpl implements ProductDao {

	FileReader reader = null;
	Properties prop = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	Scanner sc = new Scanner(System.in);

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("medicalPersistence");
	
	@Override
	public boolean addProduct(int pId, String name, String category, double price) {

		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		boolean isAdded = false;
		ProductBean productBean=new ProductBean();
		productBean.setProductId(pId);
		productBean.setProductName(name);
		productBean.setCategory(category);
		productBean.setPrice(price);

		try {
			trans.begin();
			manager.persist(productBean);
			trans.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isAdded;
	}// end of addProduct

	@Override
	public boolean updateProduct(int pId, String name, String category, double price) {
		
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		ProductBean bean=new ProductBean();
		bean.setProductId(pId);
		bean.setProductName(name);
		bean.setCategory(category);
		bean.setPrice(price);
		ProductBean productBean=new ProductBean();
		ProductBean bean1 = manager.find(ProductBean.class, pId);
		boolean isUpdate = false;

		if (bean1 != null) {
			String name1 = bean.getProductName();
			if (name != null) {
				bean1.setProductName(name1);
			}
			int id=bean.getProductId();
			if (id >0) {
				bean1.setProductId(id);
			}
			String category1=bean.getCategory();
			if (category!=null) {
				bean1.setCategory(category1);
			}	
			double price1=bean.getPrice();
			if (price>0) {
				bean1.setPrice(price1);
			}
		}

		try {
			trans.begin();
			manager.persist(bean1);
			trans.commit();
			isUpdate = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isUpdate;
	}// end of updateProduct

	@Override
	public boolean deleteProduct(int productId) {
		EntityManager manager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction trans = manager.getTransaction();
			trans.begin();
			ProductBean bean= manager.find(ProductBean.class, productId);
			manager.remove(bean);
			trans.commit();
			isDeleted = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isDeleted;
	}// end of delete Product

	@Override
	public List<ProductBean> getAllProduct() {

		EntityManager manager = emf.createEntityManager();
		String jpql = "from ProductBean";
		Query query = manager.createQuery(jpql);
		
		List<ProductBean> productList = null;
		try {
			productList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productList;
	}// end of getAllProduct


}// end of class
