package com.capgemini.springmvc.medicalshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.capgemini.springmvc.medicalshop.beans.CartBean;
import com.capgemini.springmvc.medicalshop.beans.Payment;
import com.capgemini.springmvc.medicalshop.beans.ProductBean;
import com.capgemini.springmvc.medicalshop.service.CartService;
import com.capgemini.springmvc.medicalshop.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private ProductService pService;
	
	@Autowired
	private CartService cService;
	
	@GetMapping("/cartForm")
	public String displayCart() {
		return "cartForm";
		
	}//End of displayCart()
	
	@GetMapping("/cart")
	public String cart(int userId,String productName,HttpSession session,ModelMap modelMap) {
		List<CartBean> cartBean=cService.cart(userId);
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "userLoginForm";
		
		} else {
		boolean bean=cService.addProduct(userId, productName);
			if (bean) {
				modelMap.addAttribute("cartBean", cartBean);
			} else {
				modelMap.addAttribute("msg", "Not Items in Cart");
			}
			
			return "cartForm";
		}
	}//End of cart()

	
	@GetMapping("/delete")
	public String deleteForm() {
		return "deleteForm";
	}//End of deleteForm()
	
	@GetMapping("/deleteForm")
	public String deleteFromCart(int userId,String productName,HttpSession session,ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "userLoginForm";
		
		} else {
		boolean bean=cService.deleteProduct(productName, userId);
			if (bean) {
				modelMap.addAttribute("msg", "Deleted Successfully");
			} else {
				modelMap.addAttribute("msg", "Not Items in Cart");
			}
		}
			return "deleteForm";
	}//End of deleteFromCart()
	
	@GetMapping("/cartUserId")
	public String displayCartDetails() {
		return "cartUserId";
		
	}//End of displayCart()
	
	@GetMapping("/cartDetails")
	public String cartDetails(int userId,HttpSession session,ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "userLoginForm";
		
		} else {
			List<CartBean> cartBean=cService.cart(userId);
			if (cartBean!=null) {
				modelMap.addAttribute("cartBean", cartBean);
			} else {
				modelMap.addAttribute("msg", "Not Items in Cart");
			}
			
			return "cartDetails";
		}
	}//End of cart()

	@GetMapping("/prodceedToPay")
	public String paymentPage() {
		return "paymentPage";
	}//End of Payment Page()
	
	@GetMapping("/payment")
	public String payment(int userId,String button,HttpSession session,ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "userLoginForm";
		
		} else {
			Payment payment=cService.payment(userId, button);
			if (payment.getPrice()>0) {
				modelMap.addAttribute("payment", payment);
				modelMap.addAttribute("msg","Payment Done");
			} else {
				modelMap.addAttribute("msg", "Not Items in Cart");
			}
		}
			return "paymentPage";
	}//End of payment
}//End of Controller
