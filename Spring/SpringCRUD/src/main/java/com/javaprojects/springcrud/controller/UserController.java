package com.javaprojects.springcrud.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/create")
	String create(User user) {
		
		logger.debug("Showing create");
		return "create";	
	}
	
	@PostMapping("/create")
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

	@GetMapping("/list")
	ModelAndView list() {

		List<User> users = userService.listUsers();

		logger.debug("Showing list"); 
		return new ModelAndView("list", "users", users);
	}
	
	@GetMapping("/search")
	String search() {

		logger.debug("GET: Showing search.html");
		return "search";	
	}

	@PostMapping("/search/user")
	ModelAndView search(@RequestParam String userID) {
		
		ModelAndView modelAndView = new ModelAndView();
		logger.debug("POST: Finding user with ID: " + userID);
		
		Integer id = Integer.parseInt(userID);
		User user = userService.getUserByID(id);
		
		if (user.equals(null)) {
			
			logger.debug("POST: User Not Found With Id: " + userID);
			modelAndView.setViewName("error");
			
		} else {
			
			logger.debug("POST: User Found: " + user);
			modelAndView.addObject("user", user);
			modelAndView.setViewName("user");
			
		}
		
		return modelAndView;
	}
	
	void validateUser(User user, BindingResult result) {
		
		if (Optional.ofNullable(this.userService.getUserByID(user.getIdUser())).isPresent()) {
			result.addError(new FieldError("user", "username", user.getUsername(), false, null, null, "* Username Invalid"));
		}
		
	}
	
	@GetMapping("/update/{id}") 
	ModelAndView update(@PathVariable("id") String idUser) {
		
		ModelAndView modelAndView = new ModelAndView();
		logger.debug("GET: Update User with id {}" + idUser);
		
		Integer id = Integer.parseInt(idUser);
		User user = userService.getUserByID(id);
		logger.debug("GET: Updating User {}" + user);
		
		modelAndView.addObject("user", user);
		modelAndView.setViewName("update");
		
		return modelAndView;
	}
	
	@PostMapping("/update")
	String update(@ModelAttribute("user") User user, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();
		logger.debug("POST: Update User with id {}" + user.getIdUser());

	    if (result.hasErrors()) {
	        return "update";
	    }
	    
	    userService.updateUser(user);
	    modelAndView.setViewName("list");
	   
	    return "redirect:/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") String idUser) {

		Integer id = Integer.parseInt(idUser);
		this.userService.deleteUserByID(id);

		logger.debug("GET: Showing search.html");
		return "redirect:/list";
	}

	@GetMapping("/error")
	String error() {
		
		logger.debug("GET: Display Error");
		return "error";	
	}
}