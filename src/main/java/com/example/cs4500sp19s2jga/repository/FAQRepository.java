package com.example.cs4500sp19s2jga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs4500sp19s2jga.models.FrequentlyAskedQuestion;

public interface FAQRepository
    extends CrudRepository<FrequentlyAskedQuestion, Integer> {
    @Query(value="SELECT entity FROM FrequentlyAskedQuestion entity")
    public List<FrequentlyAskedQuestion> findAllFrequentlyAskedQuestions();
    @Query(value="SELECT entity FROM FrequentlyAskedQuestion entity WHERE id=:id")
    public FrequentlyAskedQuestion findFrequentlyAskedQuestionById(
            @Param("id") Integer id);
}
