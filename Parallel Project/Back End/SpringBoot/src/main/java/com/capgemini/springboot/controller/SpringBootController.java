package com.capgemini.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {

	@GetMapping(path = "/welcome", produces = "text/plain")
	public String welcomeMessage() {	
		return "Welcome to Spring Boot";
	}// End of welcomeMessage()
}// End of Controller
