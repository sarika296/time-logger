package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Category;
import com.spring.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository; 
	

	public Category save(Category category) {
		if(category != null) {
			return categoryRepository.save(category);
		}
		return null;
	}

	public List<Category> fetchAll() {
		List<Category> listOfCategory = categoryRepository.findAll();
		if(listOfCategory != null) {
			return listOfCategory;
		}
		return null;
	}

}