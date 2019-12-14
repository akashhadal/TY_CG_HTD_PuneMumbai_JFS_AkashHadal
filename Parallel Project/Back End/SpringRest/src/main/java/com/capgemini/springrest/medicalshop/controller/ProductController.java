package com.capgemini.springrest.medicalshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrest.medicalshop.beans.MedicalResponse;
import com.capgemini.springrest.medicalshop.beans.ProductBean;
import com.capgemini.springrest.medicalshop.service.ProductService;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

@Autowired
private ProductService pService;

@PostMapping(path = "/addProduct",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
public MedicalResponse addProduct(@RequestBody ProductBean productBean) {
	boolean add=pService.addProduct(productBean);
	MedicalResponse response=new MedicalResponse();
	if (add) {
		response.setStatusCode(201);
		response.setMessage("Success");
		response.setDescription("Product Added.......");
	} else {
		response.setStatusCode(401);
		response.setMessage("Failed");
		response.setDescription("Product Not Added........");
	}
	return response;
}//End of addProduct()

@PutMapping(path = "/updateProduct",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
public MedicalResponse updateProduct(@RequestBody ProductBean productBean) {
	boolean update=pService.updateProduct(productBean);
	MedicalResponse response=new MedicalResponse();
	if (update) {
		response.setStatusCode(201);
		response.setMessage("Success");
		response.setDescription("Product updated Successfully.......");
	} else {
		response.setStatusCode(401);
		response.setMessage("Failed");
		response.setDescription("Product Not Updated........");
	}
	return response;
}//End of UpdateProduct()

@DeleteMapping(path = "/deleteProduct/{productId}")
public MedicalResponse deleteProduct(@PathVariable("productId") int productId) {
	boolean delete=pService.deleteProduct(productId);
	MedicalResponse response=new MedicalResponse();
	if (delete) {
		response.setStatusCode(201);
		response.setMessage("Success");
		response.setDescription("Product deleted Successfully.......");
	} else {
		response.setStatusCode(401);
		response.setMessage("Failed");
		response.setDescription("Product Not deleted........");
	}
	return response;
}//End of deleteProduct()

@GetMapping(path = "getAllProducts", produces = MediaType.APPLICATION_JSON_VALUE)
public MedicalResponse getAllProducts() {
	List<ProductBean> productBeans=pService.getAllProduct();
	MedicalResponse response=new MedicalResponse();
	if (productBeans!=null) {
			/*
			 * response.setStatusCode(201); response.setMessage("Success");
			 * response.setDescription("Products List Found........");
			 */
		response.setProductList(productBeans);
	} else {
		response.setStatusCode(401);
		response.setMessage("Failed");
		response.setDescription("Products List Found........");
	}
	return response;
}//End of getAllProducts()

}//End of ProductController()
