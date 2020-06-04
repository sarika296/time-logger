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
	
	public List<Category> fetchAll() {
		List<Category> listOfCategory = categoryRepository.findAll();
		if(listOfCategory != null) {
			return listOfCategory;
		}
		return null;
	}

	
	public List<Category> findByCategory(String category) {
		if(categoryRepository.existsByCategory(category) != null) {
			return categoryRepository.findByCategory(category);
		}
		return null;
	}
	

	public Category save(Category category) {
		if(categoryRepository.existsByCategory(category.getCategory()) != null) {
			return categoryRepository.save(category);
		}
		return null;
	}

	
//	public Category update(Category category, String cat) {
//		if(categoryRepository.existsByCategory(cat) != null) {
//			return categoryRepository.save(category);
//		}
//		return null;
//	}
//	
//
//	public List<Category> deleteByCategory(String category) {
//		if(categoryRepository.existsByCategory(category) != null) {
//			return categoryRepository.deleteByCategory(category);
//		}
//		return null;
//	}
}
