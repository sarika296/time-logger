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
@RequestMapping("/categorys")
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
    
    
    @GetMapping("{category}")
    public ResponseEntity<?> findByCategory(@PathVariable String category) {
        List<Category> listOfCategory = (List<Category>) categoryService.findByCategory(category);
        if (listOfCategory != null) {
            return new ResponseEntity<>(listOfCategory, HttpStatus.OK);
        } else
            return new ResponseEntity<>("No category Found", HttpStatus.BAD_REQUEST);
    }
    
    
    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        Category categorySaveResp = categoryService.save(category);
        if (Objects.nonNull(categorySaveResp)) {
            return new ResponseEntity<Category>(categorySaveResp, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    
//    @PutMapping("{category}")
//    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable("category") String t) {
//        if (t!="" && Objects.nonNull(t)) {
//            Category categoryUpdateResp = categoryService.update(category, t);
//            if (Objects.nonNull(categoryUpdateResp)) {
//                return new ResponseEntity<>(categoryUpdateResp, HttpStatus.CREATED);
//            } 
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//    
//    
//    @DeleteMapping("{category}")
//    public ResponseEntity<?> deleteByCategory(@PathVariable String category) {
//    	if(categoryService.deleteByCategory(category) != null)
//    	{
//            return new ResponseEntity<Object>(true, HttpStatus.OK);
//        } 
//        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//    }
    
}