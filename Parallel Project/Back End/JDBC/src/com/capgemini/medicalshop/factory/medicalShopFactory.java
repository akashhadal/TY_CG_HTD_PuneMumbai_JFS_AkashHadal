package com.capgemini.medicalshop.factory;

import com.capgemini.medicalshop.dao.medicalShopDAO;
import com.capgemini.medicalshop.dao.medicalShopDAOImpli;

public class medicalShopFactory {

	private medicalShopFactory() {

	}// End of Constructor

	public static medicalShopDAO getInstance() {
		medicalShopDAO dao = new medicalShopDAOImpli();
		return dao;
	}
}// End of Class
