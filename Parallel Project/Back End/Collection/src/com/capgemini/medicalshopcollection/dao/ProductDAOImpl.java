package com.capgemini.medicalshopcollection.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capgemini.medicalshopcollection.beans.ProductBean;
import com.capgemini.medicalshopcollection.database.ProductTable;


public class ProductDAOImpl implements ProductDAO {
	ProductTable productTable = new ProductTable();
	HashMap<Integer, ProductBean> productDb = productTable.productDb;

	@Override
	public boolean addProduct(ProductBean productBean) {
		if (productDb.containsKey(productBean.getProductId()) != true) {
			productDb.put(productBean.getProductId(), productBean);
			return true;
		}
		return false;
	}// End of addProduct()

	@Override
	public boolean updateProduct(int productId, double price, String available) {
		//GETTING SAME PRODUCT FROM DB AND UPDATING
		ProductBean productBean = productDb.get(productId);
		if (productDb.containsKey(productBean.getProductId())) {
			productBean.setPrice(price);
			productBean.setAvailable(available);
			productDb.put(productBean.getProductId(), productBean);
			return true;
		} else {
			return false;
		}
	}// End of update

	@Override
	public boolean searchProduct(int productId) {
		boolean ispresent = false;
		if (productDb.containsKey(productId)) {
			ispresent = true;
		}
		return ispresent;
	}// End of searchProduct()

	@Override
	public boolean removeProduct(int productId) {
		if (productDb.containsKey(productId)) {
			ProductBean productBean = productDb.get(productId);
			// Remove Product
			productDb.remove(productId);
			return true;
		} else {
			return false;
		}
	}// End of removeProduct()

	@Override
	public List<ProductBean> getAllProducts() {
		List<ProductBean> productsList = new ArrayList<ProductBean>();
		for (Integer productId : productDb.keySet()) {
			ProductBean productBean = productDb.get(productId);
			productsList.add(productBean);
		}
		return productsList;
	}// End of getAllProducts()

	

	@Override
	public ProductBean getProduct(int productId) {
		ProductBean productBean = null;
		if (productDb.containsKey(productId)) {
			return productDb.get(productId);
		} else {
			return productBean;
		}
	}//End of getProduct()

}// End of Class
