package com.javaprojects.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class _02_WelcomeController {

	@GetMapping("/welcome")
	public String welcome() {
		System.out.println("Rendering Welcome Controller");
		
		return "welcome1.html";
	}	
}