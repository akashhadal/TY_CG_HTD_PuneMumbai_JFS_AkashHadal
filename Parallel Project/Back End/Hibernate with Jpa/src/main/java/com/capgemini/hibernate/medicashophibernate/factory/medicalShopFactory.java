package com.capgemini.hibernate.medicashophibernate.factory;

import com.capgemini.hibernate.medicashophibernate.dao.medicalShopDAO;
import com.capgemini.hibernate.medicashophibernate.dao.medicalShopDAOImpli;


public class medicalShopFactory {

	private medicalShopFactory() {

	}// End of Constructor

	public static medicalShopDAO getInstance() {
		medicalShopDAO dao = new medicalShopDAOImpli();
		return dao;
	}
}// End of Class
