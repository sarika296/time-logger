package com.spring.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.model.Category;
import com.spring.model.User;
import com.spring.repository.CategoryRepository;
import com.spring.service.CategoryService;

@ExtendWith(value = { SpringExtension.class })
@WebMvcTest(CategoryController.class)

class CategoryControllerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	CategoryRepository categoryRepository;
	
	@Autowired
	WebApplicationContext context;
	
	Category category;
	
	@MockBean
	CategoryService categoryService;
	
	@BeforeEach
	void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        category = new Category();
        category.setCategory("test");
	}
	
//	@Test
//	void getAllCategoryStatus_200() throws Exception {
//		List<Category> listOfCategory = new ArrayList();
//		listOfCategory.add(category);
//		when(categoryService.fetchAll()).thenReturn(listOfCategory);
//		ObjectMapper mapper = new ObjectMapper();
//		String body = mapper.writeValueAsString(listOfCategory);
//		mockMvc.perform(get("/rest/category")).andDo(print())
//		.andExpect(listOfCategory).andExpect(status().isOk());
//	}
}