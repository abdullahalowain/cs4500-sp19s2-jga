package com.example.cs4500sp19s2jga.services;

import java.util.List;

import com.example.cs4500sp19s2jga.models.Service;

public interface ServiceService {
    public List<Service> findAllServices();
    public Service findServiceById(Integer id);
    public List<Service> findAllServicesForUser(Integer userId);
}
