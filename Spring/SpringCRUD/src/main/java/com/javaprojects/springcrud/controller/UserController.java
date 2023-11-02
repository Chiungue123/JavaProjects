package com.javaprojects.springcrud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javaprojects.springcrud.bean.User;
import com.javaprojects.springcrud.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/")
	String showIndex() {
		
		logger.debug("Showing index");
		return "index";
	}
	
	@GetMapping("/list")
	ModelAndView list() {
		
		List<User> users = userService.listUsers();
		
		logger.debug("Showing list"); 
		return new ModelAndView("list", "users", users);
	}
	
	@GetMapping("/create")
	String create(User user) {
		
		logger.debug("Showing create");
		return "create";	
	}
	
	@PostMapping("/create/new")
	ModelAndView success(@ModelAttribute("user") User user, BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView();

	    if (result.hasErrors()) {
	        modelAndView.setViewName("error");
	        return modelAndView;
	    }

	    int rowsAffected = userService.createUser(user);
	    modelAndView.addObject("rowsAffected", rowsAffected);
	    modelAndView.addObject("user", user);
	    modelAndView.setViewName("success");

	    logger.debug("Create User Post Method - Rows affected: {}", rowsAffected);
	    return modelAndView;	
	}
	
	@GetMapping("/search")
	String search() {
		
		logger.debug("Showing search");
		return "search";	
	}
	
	@GetMapping("/error")
	String error() {
		
		logger.debug("Showing search");
		return "error";	
	}
}