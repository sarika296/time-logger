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

	
	public List<User> findByUsername(String username) {
		if(userRepository.existsByUsername(username) != null) {
			return userRepository.findByUsername(username);
		}
		return null;
	}
	

	public User save(User user) {
		if(userRepository.existsByUsername(user.getUsername()) != null) {
			return userRepository.save(user);
		}
		return null;
	}

	
	public User update(User user, String username) {
		if(userRepository.existsByUsername(username) != null) {
			return userRepository.save(user);
		}
		return null;
	}
	

//	public List<User> deleteByUsername(String username) {
//		if(userRepository.existsByUsername(username) != null) {
//			return userRepository.deleteByUsername(username);
//		}
//		return null;
//	}

	
}
