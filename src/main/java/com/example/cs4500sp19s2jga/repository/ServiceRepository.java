package com.example.cs4500sp19s2jga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs4500sp19s2jga.models.Service;

public interface ServiceRepository
    extends CrudRepository<Service, Integer> {
    @Query(value="SELECT service FROM Service service")
    public List<Service> findAllServices();
    @Query(value="SELECT service FROM Service service WHERE id=:serviceId")
    public Service findServiceById(
            @Param("serviceId") Integer id);
}
