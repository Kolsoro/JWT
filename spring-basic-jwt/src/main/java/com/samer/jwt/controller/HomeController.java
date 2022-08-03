package com.samer.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "hello world";
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello Universe";
	}
}
