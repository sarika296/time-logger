package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public List<Category> existsByCategory(String category);
	
	public List<Category> findByCategory(String category);

	public List<Category> deleteByCategory(String category);
	
}