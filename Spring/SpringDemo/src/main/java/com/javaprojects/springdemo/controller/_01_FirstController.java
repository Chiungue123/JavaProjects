package com.javaprojects.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class _01_FirstController {

	@GetMapping("/hello")
	@ResponseBody public String hello() {
		return "<html>"
				+ "<h1>Hello From First Controller</h1>"
				+ "<a href='https://www.google.ca/'> Google </a>"
				+ "</html>";
	}
}