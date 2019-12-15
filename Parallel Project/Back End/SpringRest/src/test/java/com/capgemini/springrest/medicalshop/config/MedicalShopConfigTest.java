package com.capgemini.springrest.medicalshop.config;

import org.springframework.context.annotation.Configuration;

import com.capgemini.springrest.medicalshop.dao.MedicalShopDAOImpli;
import com.capgemini.springrest.medicalshop.dao.medicalShopDAO;

@Configuration
public class MedicalShopConfigTest {

	 public medicalShopDAO getMedicalShopDAO() {
		 return new MedicalShopDAOImpli();
	 }
}
