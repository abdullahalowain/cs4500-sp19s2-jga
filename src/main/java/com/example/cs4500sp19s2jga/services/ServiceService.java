package com.example.cs4500sp19s2jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s2jga.models.Service;
import com.example.cs4500sp19s2jga.repository.ServiceRepository;
import com.example.cs4500sp19s2jga.repository.UserRepository;

@RestController
@CrossOrigin(origins="*")
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/api/services")
    public List<Service> findAllServices() {
        return serviceRepository.findAllServices();
    }
    @GetMapping("/api/users/{userId}/services")
    public List<Service> findAllServicesForUser(
            @PathVariable("userId") Integer userId) {
        return userRepository.findUserById(userId).getServices();
    }
}
