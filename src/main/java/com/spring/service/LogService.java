package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Log;
import com.spring.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository logRepository; 
	
	public Log findById(Integer id) {
		if(logRepository.existsById(id)) {
			return logRepository.findById(id).get();
		}
		return null;
	}

	public Log save(Log log) {
		if(!logRepository.existsById(log.getId())) {
			return logRepository.save(log);
		}
		return null;
	}

	public Log update(Log log, Integer id) {
		if(logRepository.existsById(id)) {
			//logRepository.deleteById(id);
			return logRepository.save(log);
		}
		return null;
	}

	public boolean deleteById(Integer id) {
		if(logRepository.existsById(id)) {
			logRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Log> fetchAll() {
		List<Log> listOfLog = logRepository.findAll();
		if(listOfLog != null) {
			return listOfLog;
		}
		return null;
	}

	@Override
	public String toString() {
		return logRepository.toString();
	}
	
}
