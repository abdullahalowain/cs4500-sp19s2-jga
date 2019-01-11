package com.example.cs4500sp19s2jga.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/api/hello")
	public String sayHello() {
		return "Hello World";
	}
}
