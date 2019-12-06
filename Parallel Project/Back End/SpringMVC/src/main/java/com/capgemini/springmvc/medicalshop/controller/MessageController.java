package com.capgemini.springmvc.medicalshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.springmvc.medicalshop.beans.MessageBean;
import com.capgemini.springmvc.medicalshop.beans.UserBean;
import com.capgemini.springmvc.medicalshop.service.MessageService;

@Controller
public class MessageController {

	@Autowired
	private MessageService service;
	
	@GetMapping("/userQuery")
	public String displayUserQuery(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "adminLoginForm";

		} else {
			// Valid Session
			List<MessageBean> messageList = service.getMessage();
			// List<EmployeeInfoBean> employeesList = service.getAllEmployees();
			modelMap.addAttribute("messageList", messageList);

			return "userMessageList";
		}
	}// End of displayUserQuery()
	
	@GetMapping("/replyUser")
	public String displayUSerReplyForm() {
		return "userReplyForm";
	}//End of displayUSerReplyForm()
	
	@PostMapping("/userReply")
	public String userReply(String message,String type, int userId, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Register....");

			return "adminLoginForm";
		} else {
			// Valid Session
			if (service.sendResponse(message, type, userId)) {
				modelMap.addAttribute("msg", " User Reply Successfully");
			} else {
				modelMap.addAttribute("msg", "Unable to reply");
			}
			return "userReplyForm";
		}
	}// End of registerUser()
	
	@GetMapping(path = "/discussion")
	public String displayDisscussionBoard() {
		return "disscusionBoard";
	}//End of displayDisscutionBoard()
	
	@GetMapping(path = "/adminResponse")
	public String adminResponse() {
		return "adminResponse";
	}
	
	@GetMapping(path = "/adminResponseForm")
	public String displayAdminResponse(int userId, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Login First");
			return "userLoginForm";

		} else {
			// Valid Session
			List<MessageBean> messageList = service.getResponse(userId);
			// List<EmployeeInfoBean> employeesList = service.getAllEmployees();
			modelMap.addAttribute("messageList", messageList);

			return "adminReply";
		}
	}//End of displayAdminResponse()
	
	@GetMapping(path = "/AdminQuery")
	public String displayadminQuery() {
		return "adminQueryForm";
		}//End of adminQuery()
	
	@PostMapping(path = "/adminQueryForm")
	public String adminQueryForm(String message,String type, int userId, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			// Invalid Session
			modelMap.addAttribute("msg", "Please Register....");

			return "adminLoginForm";
		} else {
			// Valid Session
			if (service.sendResponse(message, type, userId)) {
				modelMap.addAttribute("msg", " User Query Sent");
			} else {
				modelMap.addAttribute("msg", "Unable to Sent");
			}
			return "adminQueryForm";
		}
	}//End of adminQueryForm()
	
}//End of MessageController()
