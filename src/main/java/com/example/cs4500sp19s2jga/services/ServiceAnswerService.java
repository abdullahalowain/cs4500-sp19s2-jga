package com.example.cs4500sp19s2jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s2jga.models.ServiceAnswer;
import com.example.cs4500sp19s2jga.repository.ServiceAnswerRepository;

@RestController
@CrossOrigin(origins="*")
public class ServiceAnswerService {
	@Autowired
	ServiceAnswerRepository repository;
	@GetMapping("/api/service-answers")
	public List<ServiceAnswer> findAllServiceAnswers() {
		return repository.findAllServiceAnswers();
	}
	@GetMapping("/api/service-answers/{id}")
	public ServiceAnswer findServiceAnswerById(
			@PathVariable("id") Integer id) {
		return repository.findServiceAnswerById(id);
	}
}
