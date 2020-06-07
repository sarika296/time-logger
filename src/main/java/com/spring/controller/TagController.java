package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.model.Tag;
import com.spring.service.TagService;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<?> getAllTag() {
        List<Tag> listOfTag = tagService.fetchAll();
        if (listOfTag != null) {
            return new ResponseEntity<>(listOfTag, HttpStatus.OK);
        } else
            return new ResponseEntity<>("No tag Found", HttpStatus.BAD_REQUEST);
    }
    
    
    @GetMapping("{tag}")
    public ResponseEntity<?> findByTag(@PathVariable String tag) {
        String category = tagService.findByTag(tag);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else
            return new ResponseEntity<>("No tag Found", HttpStatus.BAD_REQUEST);
    }
    
    
    @PostMapping
    public ResponseEntity<?> addTag(@RequestBody Tag tag) {
        Tag tagSaveResp = tagService.save(tag);
        if (Objects.nonNull(tagSaveResp)) {
            return new ResponseEntity<Tag>(tagSaveResp, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}