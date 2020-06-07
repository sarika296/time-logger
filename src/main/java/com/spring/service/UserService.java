package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.User;
import com.spring.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository; 
	
	public List<User> fetchAll() {
		List<User> listOfUser = userRepository.findAll();
		if(listOfUser != null) {
			return listOfUser;
		}
		return null;
	}

	public User save(User user) {
		if(user != null && !userRepository.existsByUsername(user.getUsername())) {
			return userRepository.save(user);
		}
		return null;
	}
	
}