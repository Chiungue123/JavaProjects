package com.javaprojects.springcrud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	// Instead of System.out.println, let's use Logger
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/")
	String showIndex() {
		
		logger.debug("Showing index"); // Substitutes System.out.println
		return "index";
	}
	
	@GetMapping("/list")
	String list() {
		
		logger.debug("Showing list"); // Substitutes System.out.println
		return "list";	
	}
	
	@GetMapping("/create")
	String create() {
		
		logger.debug("Showing create"); // Substitutes System.out.println
		return "create";	
	}
	
	@GetMapping("/search")
	String search() {
		
		logger.debug("Showing search"); // Substitutes System.out.println
		return "search";	
	}
}