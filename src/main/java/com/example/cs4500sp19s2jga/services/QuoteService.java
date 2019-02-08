package com.example.cs4500sp19s2jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s2jga.models.Quote;
import com.example.cs4500sp19s2jga.repository.QuoteRepository;

@RestController
public class QuoteService {
    @Autowired
    QuoteRepository repository;
    @GetMapping("/api/quotes")
    public List<Quote> findAllQuotes() {
        return repository.findAllQuotes();
    }
    @GetMapping("/api/quotes/{quoteId}")
    public Quote findQuoteById(
            @PathVariable("quoteId") Integer id) {
        return repository.findQuoteById(id);
    }
}
