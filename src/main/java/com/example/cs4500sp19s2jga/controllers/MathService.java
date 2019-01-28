package com.example.cs4500sp19s2jga.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathService {
	  @GetMapping("/api/{a}/plus/{b}")
	  public Float aPlusB(
	        @PathVariable("a") Float a,
	        @PathVariable("b") Float b) {
	     return a + b;
	  }
}
