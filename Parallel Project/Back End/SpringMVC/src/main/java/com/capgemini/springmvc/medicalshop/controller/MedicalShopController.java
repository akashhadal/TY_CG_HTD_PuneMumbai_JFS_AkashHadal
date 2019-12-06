package com.capgemini.springmvc.medicalshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.capgemini.springmvc.medicalshop.beans.AdminBean;
import com.capgemini.springmvc.medicalshop.beans.UserBean;
import com.capgemini.springmvc.medicalshop.service.MedicalShopService;

@Controller
public class MedicalShopController {

	@Autowired
	private MedicalShopService service;

	@GetMapping("/homePage")
	public String displayHomePage() {
		return "homePage";
	}// End of HomePage

	@GetMapping("/adminLoginForm")
	public String displayAdminLoginForm() {
		return "adminLoginForm";
	}// End of displayAdminLoginForm()

	@PostMapping("/adminLogin")
	public String adminLogin(String adminName, String adminPassword, ModelMap modelMap, HttpServletRequest req) {
		AdminBean adminBean = service.loginAdmin(adminName, adminPassword);
		if (adminBean != null) {
			// Valid Credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("adminBean", adminBean);

			return "adminTest";
		} else {
			// Invalid Credentials
			modelMap.addAttribute("msg", "Invalid Credentials");
			return "adminLoginForm";
		}

	}// End of AdminLogin()

	@GetMapping("/userLoginForm")
	public String displayUserLoginForm() {
		return "userLoginForm";
	}// End of displayUserLoginForm()

	@PostMapping("/userLogin")
	public String displayUserLoginForm(String userName, String userPassword, ModelMap modelMap,
			HttpServletRequest req) {
		UserBean userBean = service.loginUser(userName, userPassword);
		if (userBean != null) {
			// Valid Credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("userBean", userBean);

			return "userTest";
		} else {
			// Invalid Credentials
			modelMap.addAttribute("msg", "Invalid Credentials");
			return "userLoginForm";
		}
	}// End of displayAdminLoginForm()

	@GetMapping("/userList")
	public String displayUserList(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "adminLoginForm";

		} else {
			// Valid Session
			List<UserBean> userList = service.getAllUser();
			// List<EmployeeInfoBean> employeesList = service.getAllEmployees();
			modelMap.addAttribute("userList", userList);

			return "userList";
		}
	}// End of displayUserList()

	@GetMapping("/home")
	public String displaylHomePage(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "adminLoginForm";

		} else {
			// Valid Session
			return "homePage";
		}
	}// End of displayhomePage()

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap modelMap) {
		session.invalidate();

		modelMap.addAttribute("msg", "Logged out Successfully");
		return "homePage";
	}// End of Logout

	@GetMapping("/registerationForm")
	public String displayRegistrationPage() {
		return "registerUser";
	}// End of displayRegistrationPage()

	@PostMapping("/register")
	public String registerUser(UserBean userBean, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Register....");

			return "adminLoginForm";
		} else {
			// Valid Session
			if (service.registerUser(userBean)) {
				modelMap.addAttribute("msg", " Registration Successfully");
			} else {
				modelMap.addAttribute("msg", "Unable to Register");
			}
			return "addProductForm";
		}
	}// End ofregisterUser()

	@GetMapping("/updateUserForm")
	public String displayUpdateUser() {
		return "updateUserForm";
	}// End of displayUpdateUser()

	@PostMapping("/updateUser")
	public String updateUser(UserBean userBean, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login....");

			return "updateUserForm";
		} else {
			// Valid Session
			if (service.updateUserProfile(userBean)) {
				modelMap.addAttribute("msg", " Update Successfully");
			} else {
				modelMap.addAttribute("msg", "Unable to Update");
			}
			return "updateUserForm";
		}
	}// End of updateUser()
}// End of Controller
