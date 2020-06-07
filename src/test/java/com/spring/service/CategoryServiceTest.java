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

import com.spring.model.Category;
import com.spring.repository.CategoryRepository;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

	Category category;
	@InjectMocks
	CategoryService categoryService;
	 
	@Mock
	CategoryRepository categoryRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		category = new Category();
		category.setCategory("test");
	}
	
	@Test
	void saveSuccess(){
		when(categoryRepository.save(category)).thenReturn(category);
		assertNotNull(categoryService.save(category));
		assertEquals(category.toString(),categoryService.save(category).toString());
	}
	 
	@Test
	void saveFailure(){
	assertNull(categoryService.save(null));
	}
	
	@Test
	void fetchAllTestWithPositiveFlow() {
		List<Category> listOfCategory = new ArrayList();
		listOfCategory.add(category);
		when(categoryRepository.findAll()).thenReturn(listOfCategory);
		assertEquals(listOfCategory.toString(),categoryService.fetchAll().toString());
	}
	
	@Test 
	void fetchAllTestWithNegativeFlow() {
		when(categoryRepository.findAll()).thenReturn(null);
		assertNull(categoryService.fetchAll());
	}
}