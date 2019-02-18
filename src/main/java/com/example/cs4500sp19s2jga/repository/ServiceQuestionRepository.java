package com.example.cs4500sp19s2jga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs4500sp19s2jga.models.ServiceQuestion;

public interface ServiceQuestionRepository
    extends CrudRepository<ServiceQuestion, Integer> {
    @Query(value="SELECT entity FROM ServiceQuestion entity")
    public List<ServiceQuestion> findAllServiceQuestions();
    @Query(value="SELECT entity FROM ServiceQuestion entity WHERE id=:id")
    public ServiceQuestion findServiceQuestionById(
            @Param("id") Integer id);
}