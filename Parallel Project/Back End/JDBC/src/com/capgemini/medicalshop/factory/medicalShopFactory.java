package com.capgemini.medicalshop.factory;

import com.capgemini.medicalshop.dao.MedicalShopDAO;
import com.capgemini.medicalshop.dao.MedicalShopDAOImpli;

public class MedicalShopFactory {

	private MedicalShopFactory() {

	}// End of Constructor

	public static MedicalShopDAO getInstance() {
		MedicalShopDAO dao = new MedicalShopDAOImpli();
		return dao;
	}
}// End of Class
