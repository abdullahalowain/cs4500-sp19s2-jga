package com.example.cs4500sp19s2jga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cs4500sp19s2jga.models.Quote;

public interface PagedQuoteRepository extends JpaRepository<Quote, Integer> {

}
