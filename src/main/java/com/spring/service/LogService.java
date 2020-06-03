package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.model.Log;
import com.spring.repository.UserRepository;

@Component
@Service
public class LogService {

	@Autowired
	private UserRepository userRepository; 
	
	public Log findById(Integer id) {
		if(userRepository.existsById(id)) {
			return userRepository.findById(id).get();
		}
		return null;
	}

	public Log save(Log log) {
		if(userRepository.existsById(log.getId())) {
			return userRepository.save(log);
		}
		return null;
	}

	public Log update(Log log, Integer id) {
		if(userRepository.existsById(id)) {
			return userRepository.save(log);
		}
		return null;
	}

	public boolean deleteById(Integer id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Log> fetchAll() {
		List<Log> listOfLog = userRepository.findAll();
		if(listOfLog != null) {
			return listOfLog;
		}
		return null;
	}
}
