package com.example.cs4500sp19s2jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s2jga.models.ServiceCategory;
import com.example.cs4500sp19s2jga.repository.ServiceCategoryRepository;

@RestController
@CrossOrigin(origins="*")
public class ServiceCategoryService {
	@Autowired
	ServiceCategoryRepository serviceCategoryRepository;
	@GetMapping("/api/service-categories")
	public List<ServiceCategory> findAllServiceCategories() {
		return serviceCategoryRepository.findAllServiceCategories();
	}
	@GetMapping("/api/service-categories/{cid}")
	public ServiceCategory findServiceCategoryById(
			@PathVariable("cid") Integer cid) {
		return serviceCategoryRepository.findServiceCategoryById(cid);
	}
}