package com.capgemini.springrest.medicalshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.springrest.medicalshop.beans.ProductBean;




@Repository
public class ProductDAOImpli implements ProductDao {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public boolean addProduct(ProductBean productBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		boolean isAdded = false;

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
	}//End of addProduct()

	@Override
	public boolean updateProduct(ProductBean productBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		ProductBean bean = manager.find(ProductBean.class, productBean.getProductId());
		boolean isUpdate = false;

		if (bean != null) {
			String name = productBean.getProductName();
			if (name != null) {
				bean.setProductName(name);
			}
			
			int id=productBean.getProductId();
			if (id >0) {
				bean.setProductId(id);
			}
			String category=productBean.getCategory();
			if (category!=null) {
				bean.setCategory(category);;
			}	
			double price=productBean.getPrice();
			if (price>0) {
				bean.setPrice(price);
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
	}//End of updateProduct()

	@Override
	public boolean deleteProduct(int productId) {
		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			ProductBean bean= entityManager.find(ProductBean.class, productId);
			entityManager.remove(bean);
			tx.commit();
			isDeleted = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return isDeleted;
	}//End of deleteProduct()

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
	}//End of getAllProducts()

}//End of DAOIpli()
