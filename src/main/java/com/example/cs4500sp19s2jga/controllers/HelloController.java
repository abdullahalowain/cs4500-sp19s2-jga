package com.example.cs4500sp19s2jga.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s2jga.models.HelloObject;

@RestController
public class HelloController {
	@GetMapping("/api/hello")
	public String sayHello() {
		return "Hello World";
	}

	@GetMapping("/api/hello/object")
	public HelloObject getHelloObject() {
		HelloObject hello = new HelloObject();
		hello.setMessage("Hello World Object");
		return hello;
	}
	@GetMapping("/api/hello/parameter/{someMessage}")
	public HelloObject getHelloObjectParameter(
			@PathVariable("someMessage") String message) {
		HelloObject hello = new HelloObject();
		hello.setMessage(message);
		return hello;
	}
}
