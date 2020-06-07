package com.spring.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.model.Log;
import com.spring.model.Log;
import com.spring.repository.LogRepository;

@ExtendWith(MockitoExtension.class)
class LogServiceTest {

	Log log;
	@InjectMocks
	LogService logService;
	 
	@Mock
	LogRepository logRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		log = new Log();
		log.setId(1);
		log.setUsername("ajayff4");
		log.setCompleted(false);
		log.setTime("0000");
		log.setDate("06/21/2020");
		log.setDuration(10);
		log.setLog_details("testLog");
	}
	
	@Test
	void saveSuccess(){
		when(logRepository.existsById(log.getId())).thenReturn(false);
		when(logRepository.save(log)).thenReturn(log);
		assertNotNull(logService.save(log));
		assertEquals(log.toString(),logService.save(log).toString());
	}
	
	@Test
	void saveFailure() {
		when(logRepository.existsById(log.getId())).thenReturn(true);
		assertNull(logService.save(log));
	}
	
	@Test
	void deleteByIdSuccess() {
		when(logRepository.existsById(log.getId())).thenReturn(true);
		doNothing().when(logRepository).deleteById(log.getId());
		assertTrue(logService.deleteById(log.getId()));
	}
	
	@Test
	void deleteByIdFailure() {
		when(logRepository.existsById(log.getId())).thenReturn(false);
		assertFalse(logService.deleteById(log.getId()));
	}
	
	@Test
	void fetchAllPositiveFlow() {
		List<Log> listOfLog = new ArrayList();
		listOfLog.add(log);
		when(logRepository.findAll()).thenReturn(listOfLog);
		assertEquals(listOfLog.toString(),logService.fetchAll().toString());
	}
	
	@Test
	void fetchAllNegativeFlow() {
		when(logRepository.findAll()).thenReturn(null);
		assertNull(logService.fetchAll());
	}
	
	@Test 
	void findByIdPositiveFlow() {
		when(logRepository.existsById(log.getId())).thenReturn(true);
		Optional<Log> optLog = Optional.of(log);
		when(logRepository.findById(log.getId())).thenReturn(optLog);
		assertEquals(optLog.get(), logService.findById(log.getId()));
	}
	
	@Test
	void findByIdNegativeFlow() {
		when(logRepository.existsById(log.getId())).thenReturn(false);
		assertNull(logService.findById(log.getId()));
	}
	
	@Test 
	void updatePositiveFlow() {
		when(logRepository.existsById(log.getId())).thenReturn(true);
		doNothing().when(logRepository).deleteById(log.getId());
		when(logRepository.save(log)).thenReturn(log);
		assertEquals(log.toString(), logService.update(log, log.getId()).toString());
	}
	
	@Test
	void updateNegativeFlow() {
		when(logRepository.existsById(log.getId())).thenReturn(false);
		assertNull(logService.update(log, log.getId()));
	}
	
}