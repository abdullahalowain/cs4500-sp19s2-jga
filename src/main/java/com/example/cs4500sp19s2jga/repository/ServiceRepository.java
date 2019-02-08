package com.example.cs4500sp19s2jga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.cs4500sp19s2jga.models.Service;

public interface ServiceRepository
    extends CrudRepository<Service, Integer> {
    @Query(value="SELECT service FROM Service service")
    public List<Service> findAllServices();
}
