package com.pickme.beeze.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {
	
	
	@GetMapping("hello")
	public String hello() {
	
		return "hello";
		
	}
}
