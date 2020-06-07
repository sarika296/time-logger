package com.spring.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.model.Tag;
import com.spring.model.User;
import com.spring.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	User user;
	@InjectMocks
	UserService userService;
	@Mock
	UserRepository userRepository;
	@BeforeEach
	void setUp() throws Exception {
		user = new User();
		user.setUsername("test");
		user.setEmail("test@gmail.com");
		user.setFullname("test,ing");
		user.setPassword("0000");
	}

	@Test
	void fetchAllPositiveFlow() {
		List<User> listOfUser = new ArrayList();
		listOfUser.add(user);
		when(userRepository.findAll()).thenReturn(listOfUser);
		assertEquals(listOfUser.toString(),userService.fetchAll().toString());
	}
	
	@Test
	void fetchAllNegativeFlow() {
		when(userRepository.findAll()).thenReturn(null);
		assertNull(userService.fetchAll());
	}
	
	@Test
	void saveTestPositiveFlow() {
		when(userRepository.existsByUsername(user.getUsername())).thenReturn(false);
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user.toString(),userService.save(user).toString());
	}
	
	@Test
	void saveTestNegativeFlow() {
		assertNull(userService.save(null));
	}
	
	@Test
	void saveTestNegativeFlowWhenUserIsNotNull() {
		when(userRepository.existsByUsername(user.getUsername())).thenReturn(true);
		assertNull(userService.save(user));
	}

}
