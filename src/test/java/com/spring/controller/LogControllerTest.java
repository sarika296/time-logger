package com.spring.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.spring.model.Category;
import com.spring.repository.CategoryRepository;
import com.spring.service.CategoryService;

class LogControllerTest {
	
	Category category;
	@InjectMocks
	CategoryService categoryService;
	 
	@Mock
	CategoryRepository categoryRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		category = new Category();
		category.setCategory("test");
//		category.setCategory("official");
//		category.setCategory("non-official");
		
	}

	
	
	@Test
	void saveSuccess(){
		when(categoryRepository.save(category)).thenReturn(category);
		assertNotNull(categoryService.save(category));
		assertEquals(category.toString(),categoryService.save(category));
	}
	 
	@Test
	void saveFailure(){
	assertNull(categoryService.save(null));
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
//	@AfterEach
//	void tearDown() throws Exception {
//		
//	}

}
