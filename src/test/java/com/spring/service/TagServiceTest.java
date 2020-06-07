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
import com.spring.repository.TagRepository;

@ExtendWith(MockitoExtension.class)
class TagServiceTest {

	Tag tag;
	@InjectMocks
	TagService tagService;
	@Mock
	TagRepository tagRepository;
	@BeforeEach
	void setUp() throws Exception {
		tag = new Tag();
		tag.setTag("testTag");
		tag.setCategory("testCat");
	}

	@Test
	void saveTagTestPositiveFlow() {
		when(tagRepository.save(tag)).thenReturn(tag);
		assertEquals(tag.toString(),tagService.save(tag).toString());
	}
	
	@Test
	void saveTagTestNegativeFlow() {
		assertNull(tagService.save(null));
	}
	
	@Test 
	void findByTagPositiveFlow() {
		when(tagRepository.existsByTag(tag.getTag())).thenReturn(true);
		when(tagRepository.findByTag(tag.getTag())).thenReturn(tag);
		assertEquals(tag.getCategory(), tagService.findByTag(tag.getTag()));
	}
	
	@Test
	void findByTagNegativeFlow() {
		when(tagRepository.existsByTag(tag.getTag())).thenReturn(false);
		assertNull(tagService.findByTag(tag.getTag()));
	}
	
	@Test
	void fetchAllPositiveFlow() {
		List<Tag> listOfTag = new ArrayList();
		listOfTag.add(tag);
		when(tagRepository.findAll()).thenReturn(listOfTag);
		assertEquals(listOfTag.toString(),tagService.fetchAll().toString());
	}
	
	@Test
	void fetchAllNegativeFlow() {
		when(tagRepository.findAll()).thenReturn(null);
		assertNull(tagService.fetchAll());
	}
	
}
