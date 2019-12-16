package com.capgemini.medicalshop.factory;

import com.capgemini.medicalshop.dao.MedicalShopDAOImpli;
import com.capgemini.medicalshop.dao.medicalShopDAO;

public class TestMedicalFactory {

	private TestMedicalFactory() {
		
	}
	
	public static medicalShopDAO getInstance() {
		medicalShopDAO dao=new MedicalShopDAOImpli();
		return dao;
	}
}
