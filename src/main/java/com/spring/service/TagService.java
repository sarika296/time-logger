package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Tag;
import com.spring.repository.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository userRepository; 
	
	public List<Tag> fetchAll() {
		List<Tag> listOfTag = userRepository.findAll();
		if(listOfTag != null) {
			return listOfTag;
		}
		return null;
	}

	
	public List<Tag> findByTagname(String tag) {
		if(userRepository.existsByTag(tag) != null) {
			return userRepository.findByTag(tag);
		}
		return null;
	}
	

	public Tag save(Tag user) {
		if(userRepository.existsByTag(user.getTag()) != null) {
			return userRepository.save(user);
		}
		return null;
	}

	
//	public Tag update(Tag user, String tag) {
//		if(userRepository.existsByTag(tag) != null) {
//			return userRepository.save(user);
//		}
//		return null;
//	}
//	
//
//	public List<Tag> deleteByTag(String tag) {
//		if(userRepository.existsByTag(tag) != null) {
//			return userRepository.deleteByTag(tag);
//		}
//		return null;
//	}
}
