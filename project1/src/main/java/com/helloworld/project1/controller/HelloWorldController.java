package com.helloworld.project1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/helloworld")
public class HelloWorldController {
	
	@GetMapping 
	public String helloworld () {
		
		return "Olá mundo!";
	}

}
