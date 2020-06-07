package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {

	public boolean existsByTag(String tag);
	
	public Tag findByTag(String tag);

	public List<Tag> deleteByTag(String tag);
	
	

}