package com.example.cs4500sp19s2jga.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cs4500sp19s2jga.models.User;

public interface UserRepository
	extends CrudRepository<User, Integer> {
	@Query(value="SELECT user FROM User user WHERE user.id=:id")
	public User findUserById(@Param("id") Integer id);
}
