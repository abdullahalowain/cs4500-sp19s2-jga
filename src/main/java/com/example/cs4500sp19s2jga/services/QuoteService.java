package com.example.cs4500sp19s2jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s2jga.models.Quote;
import com.example.cs4500sp19s2jga.repository.QuoteRepository;

@RestController
@CrossOrigin(origins="*")
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
    @PostMapping("/api/quotes")
    public Quote createQuote(@RequestBody Quote quote) {
        return repository.save(quote);
    }
    @PutMapping("/api/quotes/{id}")
    public Quote updateQuote(
            @PathVariable("id") Integer id,
            @RequestBody Quote newQuote) {
        Quote quote = repository.findQuoteById(id);
        quote.setJobTitle(newQuote.getJobTitle());
        return repository.save(quote);
    }
    @DeleteMapping("/api/quotes/{id}")
    public void deleteQuote(
            @PathVariable("id") Integer id) {
        repository.deleteById(id);
    }
}
