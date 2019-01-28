package com.example.cs4500sp19s2jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s2jga.models.Review;
import com.example.cs4500sp19s2jga.repository.ReviewRepository;

@RestController
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	@GetMapping("/api/reviews")
	public List<Review> findAllReviews() {
		return reviewRepository.findAllReviews();
	}
}
