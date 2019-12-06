package com.capgemini.springmvc.medicalshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.capgemini.springmvc.medicalshop.beans.ProductBean;
import com.capgemini.springmvc.medicalshop.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@GetMapping("/addProductForm")
	public String displayAddProduct(HttpSession session,ModelMap modelMap) {
		if (session.isNew()) {
			modelMap.addAttribute("msg", "Please Login First....");

			return "adminLoginForm";
		} else {
			return "addProductForm";
		}
	}//End of displayAddProduct()
	
	@PostMapping("/addProduct")
	public String addProduct(ProductBean productBean,HttpSession session,ModelMap modelMap) {
		if (session.isNew()) {
			//Invalid Session
			modelMap.addAttribute("msg", "Please Login First....");

			return "adminLoginForm";
		} else {
			//Valid Session
			if(pService.addProduct(productBean)) {
				modelMap.addAttribute("msg", "Product Added Successfully");
			}else {
				modelMap.addAttribute("msg", "Unable to add Product");
			}
			return "addProductForm";
		}
	}//End of addProduct()
	
	@GetMapping("/updateProductForm")
	public String displayUpdateProduct(HttpSession session,ModelMap modelMap) {
		if(session.isNew()) {
			//Invalid Session
			modelMap.addAttribute("msg", "please Login First....");
			return "adminLoginForm";
		}else {
			//Valid Session
			return "updateProductForm";
		}
	}//End of displayUpdateProduct()
	
	@PostMapping("/updateProduct")
	public String updateProduct(ProductBean productBean,HttpSession session,ModelMap modelMap) {
		if(session.isNew()) {
			//Invalid Session
			
			modelMap.addAttribute("msg", "please Login First....");
			return "adminLoginForm";
		}else {
			//Valid Session
			if(pService.updateProduct(productBean)) {
				modelMap.addAttribute("msg", "Product Details Updated....");
			}else {
				modelMap.addAttribute("msg", "Unable to update Product Details....");
			}
			return "updateProductForm";
		}		
	}//End of updateProduct()
	
	@GetMapping("/deleteProductForm")
	public String displayDeleteProduct(HttpSession session,ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "adminLoginForm";
		
		} else {
			// Valid Session
			return "deleteProductForm";
		}
	}//End of displayDeleteProduct()
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(int productId, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "adminLoginForm";
		
		} else {
			// Valid Session
			if(pService.deleteProduct(productId)) {
				modelMap.addAttribute("msg", "Product Deleted Successfully!");
			} else {
				modelMap.addAttribute("msg", "Product ID " + productId + " Not Found!");
			}
			
			return "deleteProductForm";
		}
	}// End of searchEmployee()
	
	@GetMapping("/allProduct")
	public String displayAllProduct(HttpSession session,ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "adminLoginPage";
		
		} else {
			// Valid Session
			List<ProductBean> productList=pService.getAllProduct();
			//List<EmployeeInfoBean> employeesList = service.getAllEmployees();
			modelMap.addAttribute("productList", productList);
			
			return "allProducts";
		}
	}//End of displayAllProduct()

}//End of Product Controller
