package com.example.cs4500sp19s2jga.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.cs4500sp19s2jga.models.User;
import java.util.*;

@RestController
public class UserService {
	
	static List<User> users = new ArrayList<User>();
	static {
		User alice = new User(123, "alice", "alice", "Alice", "Wonderland");
		User bob = new User(234, "bob", "bob", "Bob", "Marley");
		users.add(alice);
		users.add(bob);
	}
	
	@GetMapping("/api/users")
	public List<User> findAllUser() {
		return users;
	}
	@GetMapping("/api/users/{userId}")
	public User findUserById(
			@PathVariable("userId") Integer userId) {
		for(User user: users) {
			if(user.getId().intValue() == userId) {
				return user;
			}
		}
		return null;
	}
//	public User findUserByUsername(String username) {
//		
//	}
//	public User createUser(User user) {
//		
//	}
//	public void deleteUser(Integer id) {
//		
//	}
}
