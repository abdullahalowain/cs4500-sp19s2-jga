package com.example.cs4500sp19s2jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.cs4500sp19s2jga.models.Service;
import com.example.cs4500sp19s2jga.repository.ServiceRepository;
import com.example.cs4500sp19s2jga.repository.UserRepository;

@org.springframework.stereotype.Service
public class DefaultServiceService implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    UserRepository userRepository;
    public List<Service> findAllServices() {
        return serviceRepository.findAllServices();
    }
    public Service findServiceById(Integer id) {
        return serviceRepository.findServiceById(id);
    }
    public List<Service> findAllServicesForUser(Integer userId) {
        return userRepository.findUserById(userId).getServices();
    }}
