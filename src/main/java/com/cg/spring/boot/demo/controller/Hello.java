package com.cg.spring.boot.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class Hello {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("api called");
		return "Hello world!";
	}

}
