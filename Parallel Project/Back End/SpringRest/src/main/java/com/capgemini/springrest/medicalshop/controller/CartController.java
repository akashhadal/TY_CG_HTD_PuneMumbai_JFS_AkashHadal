package com.capgemini.springrest.medicalshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrest.medicalshop.beans.CartBean;
import com.capgemini.springrest.medicalshop.beans.MedicalResponse;
import com.capgemini.springrest.medicalshop.beans.Payment;
import com.capgemini.springrest.medicalshop.beans.ProductBean;
import com.capgemini.springrest.medicalshop.service.CartService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

	@Autowired
	private CartService cService;
	
	@PutMapping(path = "/cartProduct",produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse cartProduct(@RequestParam int userId,@RequestParam String productName) {
		boolean add=cService.addProduct(userId, productName);
		MedicalResponse response=new MedicalResponse();
		if (add) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product Added to cart.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Product Not Added to cart........");
		}
		return response;
	}//End of cartProduct()
	
	@DeleteMapping(path = "/cartDelete",produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse cartDelete(@RequestParam String productName,@RequestParam int userId) {
		boolean delete=cService.deleteProduct(productName, userId);
		MedicalResponse response=new MedicalResponse();
		if (delete) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product deleted form cart.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Product deleted form cart........");
		}
		return response;
	}//End of cartDelete()
	
	@GetMapping(path = "/payment",produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse payment(@RequestParam int userId,@RequestParam String button,@RequestParam String address) {
		Payment pay=cService.payment(userId,button,address);
		MedicalResponse response=new MedicalResponse();
		if (pay.getPaymentStatus()=="done") {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setPrice(pay.getPrice());
			response.setDescription("Payment Done.......");
		} else if(pay.getPaymentStatus()=="fail"){
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setPrice(pay.getPrice());
			response.setDescription("payment Failed........");
		}
		return response;
	}//End of payment()
	
	@GetMapping(path = "/getCart",produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse getCart(@RequestParam int userId) {
	List<CartBean> cartBean=cService.cart(userId);
		MedicalResponse response=new MedicalResponse();
		if (cartBean!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setCartBeans(cartBean);
			response.setDescription("Cart Items Found.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Cart Empty........");
		}
		return response;
	}//End of getCart()
	
	
}//End of CartController()
