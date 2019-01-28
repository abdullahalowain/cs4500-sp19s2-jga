package com.example.cs4500sp19s2jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s2jga.models.Review;
import com.example.cs4500sp19s2jga.repository.ReviewRepository;

@RestController
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	@GetMapping("/api/users/{userId}/reviews")
	public List<Review> findReviewsOfMe(
			@PathVariable("userId") Integer userId) {
		return reviewRepository.findReviewsOfMe(userId);
	}
	@DeleteMapping("/api/reviews/{id}")
	public void deleteReview(
			@PathVariable("id") Integer id) {
		reviewRepository.deleteById(id);
	}
	@PutMapping("/api/reviews/{id}")
	public Review updateReview(
			@PathVariable("id") Integer id,
			@RequestBody Review reviewUpdates) {
		Review review = reviewRepository.findReviewById(id);
		review.setTitle(reviewUpdates.getTitle());
		review.setReview(reviewUpdates.getReview());
		return reviewRepository.save(review);
	}
	@GetMapping("/api/reviews")
	public List<Review> findAllReviews() {
		return reviewRepository.findAllReviews();
	}
	@GetMapping("/api/reviews/{id}")
	public Review findReviewById(
			@PathVariable("id") Integer id) {
		return reviewRepository.findReviewById(id);
	}
}
