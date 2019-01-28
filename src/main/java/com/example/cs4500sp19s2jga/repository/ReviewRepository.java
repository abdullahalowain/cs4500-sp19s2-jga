package com.example.cs4500sp19s2jga.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.cs4500sp19s2jga.models.Review;

public interface ReviewRepository
	extends CrudRepository<Review, Integer> {

}
