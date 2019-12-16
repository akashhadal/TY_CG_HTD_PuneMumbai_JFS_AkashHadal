package com.capgemini.medicalshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalshop.beans.CartBean;
import com.capgemini.medicalshop.beans.MedicalResponse;
import com.capgemini.medicalshop.beans.OrderBean;
import com.capgemini.medicalshop.beans.Payment;
import com.capgemini.medicalshop.beans.Payment1;
import com.capgemini.medicalshop.service.CartService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

	@Autowired
	private CartService cService;

	@PostMapping(path = "/cartProduct")
	public MedicalResponse cartProduct(@RequestBody CartBean cartBean) {
		boolean add = cService.addProduct(cartBean.getUserId(), cartBean.getProductName());
		MedicalResponse response = new MedicalResponse();
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
	}// End of cartProduct()

	@PostMapping(path = "/cartDelete")
	public MedicalResponse cartDelete(@RequestBody CartBean cartBean) {
		boolean delete = cService.deleteProduct(cartBean.getCartId(), cartBean.getUserId());
		MedicalResponse response = new MedicalResponse();
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
	}// End of cartDelete()

	@PostMapping(path = "/payment")
	public MedicalResponse payment(@RequestBody Payment1 payment1) {
		Payment pay = cService.payment(payment1.getUserId(), payment1.getAddress());
		MedicalResponse response = new MedicalResponse();
		if (pay.getPaymentStatus() == "done") {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setPrice(pay.getPrice());
			response.setDescription("Payment Done.......");
		} else if (pay.getPaymentStatus() == "fail") {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setPrice(pay.getPrice());
			response.setDescription("payment Failed........");
		}
		return response;
	}// End of payment()

	@GetMapping(path = "/viewCart/{userId}")
	public MedicalResponse viewCart(@PathVariable("userId") int userId) {
		List<CartBean> list = cService.getCart(userId);
		MedicalResponse response = new MedicalResponse();
		if (list != null) {

			 response.setStatusCode(201); 
			 response.setMessage("Success"); 
			response.setDescription("Cart Data Retriverd.......");
			response.setCartBeans(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("payment Failed........");
		}
		return response;
	}// end of viewCart()

	@GetMapping(path = "/viewOrder/{userId}")
	public MedicalResponse viewOrder(@PathVariable("userId") int userId) {
		List<OrderBean> list = cService.viewOrder(userId);
		MedicalResponse response = new MedicalResponse();

		if (list != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Order History Retrived.......");
			response.setOrderBeans(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Failed to retrive........");
		}

		return response;
	}// end of viewOrder()
	
	@GetMapping("/totalBill/{userId}")
	public MedicalResponse totalBill(@PathVariable("userId") int userId) {
		double bill=cService.totalBill(userId);
		MedicalResponse response=new MedicalResponse();
		if (bill >0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Total Bill Retrived.......");
			response.setPrice(bill);
			
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Failed to retrive........");
		}
		return response;
	}//End of toyalBill
}// End of CartController()
