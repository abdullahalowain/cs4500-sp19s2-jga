package com.example.cs4500sp19s2jga.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.cs4500sp19s2jga.models.User;

public interface UserRepository
	extends CrudRepository<User, Integer> {

}
