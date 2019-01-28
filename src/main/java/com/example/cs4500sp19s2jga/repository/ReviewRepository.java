package com.example.cs4500sp19s2jga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs4500sp19s2jga.models.Review;

public interface ReviewRepository
	extends CrudRepository<Review, Integer> {
	@Query(value="SELECT review FROM Review review")
	public List<Review> findAllReviews();
	@Query(value="SELECT review FROM Review review WHERE id=:id")
	public Review findReviewById(@Param("id") Integer id);
	@Query(value="SELECT review FROM Review review WHERE reviewed.id=:id")
	public List<Review> findReviewsOfMe(@Param("id") Integer id);
}
