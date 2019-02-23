package com.example.cs4500sp19s2jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s2jga.models.Quote;
import com.example.cs4500sp19s2jga.repository.PagedQuoteRepository;
import com.example.cs4500sp19s2jga.repository.QuoteRepository;

@RestController
@CrossOrigin(origins="*")
public class QuoteService {
    @Autowired
    PagedQuoteRepository pagedRepository;
    @Autowired
    QuoteRepository repository;
    
    @GetMapping("/api/quotes/paged")
    public Page<Quote> findPagedQuotes(
            @RequestParam(name="page", required=false) Integer page,
            @RequestParam(name="count", required=false) Integer count) {
        if(page == null) {
            page = 0;
        }
        if(count == null) {
            count = 10;
        }
        Pageable p = PageRequest.of(page, count);
        return pagedRepository.findAll(p);
    }
    
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
