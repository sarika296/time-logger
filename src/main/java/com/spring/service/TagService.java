package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Tag;
import com.spring.repository.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository; 
	
	public List<Tag> fetchAll() {
		List<Tag> listOfTag = tagRepository.findAll();
		if(listOfTag != null) {
			return listOfTag;
		}
		return null;
	}
	
	
	public String findByTag(String tag) {
		if(tagRepository.existsByTag(tag)) {
			return tagRepository.findByTag(tag).getCategory();
		}
		return null;
	}
	
	
	public Tag save(Tag tag) {
		if(tag != null) {
			return tagRepository.save(tag);
		}
		return null;
	}
}
