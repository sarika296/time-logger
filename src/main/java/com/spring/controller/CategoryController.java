package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.model.Category;
import com.spring.service.CategoryService;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public ResponseEntity<?> getAllCategory() {
        List<Category> listOfCategory = categoryService.fetchAll();
        if (listOfCategory != null) {
            return new ResponseEntity<>(listOfCategory, HttpStatus.OK);
        } else
            return new ResponseEntity<>("No category Found", HttpStatus.BAD_REQUEST);
    }
   
    
    @PostMapping("add")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
    	Category logSaveResp = categoryService.save(category);
        if (Objects.nonNull(logSaveResp)) {
            return new ResponseEntity<Category>(logSaveResp, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}