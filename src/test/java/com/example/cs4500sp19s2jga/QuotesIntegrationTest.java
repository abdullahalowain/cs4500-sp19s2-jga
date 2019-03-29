package com.example.cs4500sp19s2jga;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.cs4500sp19s2jga.models.Quote;
import com.example.cs4500sp19s2jga.repository.QuoteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class QuotesIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate rt;
    @Autowired
    private QuoteRepository qr;
    private Quote testQuote = null;
    @Before
    public void setup() {
        testQuote = new Quote();
        testQuote.setJobDescription("Test Description");
        testQuote.setJobTitle("Test Title");
        testQuote.setPrice(123.45);
        testQuote = qr.save(testQuote);
    }
    @After
    public void teardown() {
        qr.deleteById(testQuote.getId());
    }
    @Test
    public void testUpdateQuote() throws Exception {
        // insert a quote to then verify we can update it
        Quote q1 = new Quote();
        q1.setJobDescription("Update Me Quote Description");
        q1.setJobTitle("Update Me Quote Title");
        q1.setPrice(321.54);
        Quote q2 = qr.save(q1);
        // change the quote a bit
        q1.setJobDescription("Updated Quote Description");
        q1.setJobTitle("Updated Quote Title");
        q1.setPrice(123.23);
        // update quote using API
        this.rt.put(
                "http://localhost:8080/api/quotes/" + q2.getId(),
                q1);
        // try retrieving the quote after update and verify it changed
        q2 = qr.findQuoteById(q2.getId());
        assertEquals(q2.getJobDescription(), q1.getJobDescription());
        assertEquals(q2.getJobTitle(), q1.getJobTitle());
        assertEquals(q2.getPrice(), q1.getPrice());
        // remove quote inserted to clean up after test
        qr.deleteById(q2.getId());
    }
    @Test
    public void testDeleteQuote() throws Exception {
        // insert a quote to then verify we can remove it
        Quote quote = new Quote();
        quote.setJobDescription("Delete Quote Description");
        quote.setJobTitle("Delete Quote Title");
        quote.setPrice(321.54);
        Quote savedQuote = qr.save(quote);
        // remove quote using API
        this.rt.delete("http://localhost:8080/api/quotes/" + savedQuote.getId());
        // try retrieving the quote after removal and verify it's not there anymore
        Quote deletedQuote = qr.findQuoteById(savedQuote.getId());
        assertEquals(deletedQuote, null);
    }
    @Test
    public void testCreateQuote() throws Exception {
        // create a new record using the API
        Quote quote = new Quote();
        quote.setJobDescription("Create New Quote Description");
        quote.setJobTitle("Create New Quote Title");
        quote.setPrice(321.54);
        Quote createdQuote = (Quote) rt.postForObject(
                "http://localhost:8080/api/quotes",
                quote,
                Quote.class);
        // verify quote inserted is same as what was sent
        assertEquals(quote.getJobDescription(), createdQuote.getJobDescription());
        assertEquals(quote.getJobTitle(), createdQuote.getJobTitle());
        assertEquals(quote.getPrice(), createdQuote.getPrice());
        // remove quote inserted to clean up after test
        qr.deleteById(createdQuote.getId());
    }
    @Test
    public void testFindAllQuotes() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Quote>> response = restTemplate.exchange(
                "http://localhost:8080/api/quotes",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Quote>>(){});
        List<Quote> quotes1 = response.getBody();
        List<Quote> quotes2 = qr.findAllQuotes();
        assertEquals(quotes1.size(), quotes2.size());
    }
    @Test
    public void testFindQuoteById() throws Exception {
        Quote quote1 = (Quote)this.rt.getForObject(
                "http://localhost:8080/api/quotes/" + testQuote.getId(),
                Quote.class);
        Quote quote2 = qr.findQuoteById(testQuote.getId());
        assertEquals(quote1.getJobDescription(), quote2.getJobDescription());
        assertEquals(quote1.getJobTitle(), quote2.getJobTitle());
        assertEquals(quote1.getPrice(), quote2.getPrice());
        assertEquals(quote1.getId(), quote2.getId());
    }

}
