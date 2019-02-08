package com.example.cs4500sp19s2jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s2jga.models.User;
import com.example.cs4500sp19s2jga.repository.UserRepository;

@RestController
@CrossOrigin(origins="*")
public class UserService {
	@Autowired
	UserRepository userRepository;
	@GetMapping("/api/users")
	public List<User> findAllUser() {
		return (List<User>) userRepository.findAll();
	}
	@GetMapping("/api/users/{userId}")
	public User findUserById(
			@PathVariable("userId") Integer userId) {
		return userRepository.findById(userId).get();
//		for(User user: users) {
//			if(user.getId().intValue() == userId) {
//				return user;
//			}
//		}
//		return null;
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
