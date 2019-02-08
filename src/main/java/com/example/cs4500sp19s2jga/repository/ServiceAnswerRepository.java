package com.example.cs4500sp19s2jga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs4500sp19s2jga.models.ServiceAnswer;

public interface ServiceAnswerRepository
    extends CrudRepository<ServiceAnswer, Integer> {
    @Query(value="SELECT entity FROM ServiceAnswer entity")
    public List<ServiceAnswer> findAllServiceAnswers();
    @Query(value="SELECT entity FROM ServiceAnswer entity WHERE id=:id")
    public ServiceAnswer findServiceAnswerById(
            @Param("id") Integer id);
}
