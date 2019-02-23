package com.example.cs4500sp19s2jga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cs4500sp19s2jga.models.Quote;

public interface PagedQuoteRepository extends JpaRepository<Quote, Integer> {
    @Query("SELECT q FROM Quote q WHERE q.jobDescription LIKE :jd AND q.jobTitle LIKE :jt")
    public List<Quote> filterQuotes(
            @Param("jd") String jobDescription,
            @Param("jt") String jobTitle);
}
