package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.model.User;
import com.spring.service.UserService;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        List<User> listOfUser = userService.fetchAll();
        if (listOfUser != null) {
            return new ResponseEntity<>(listOfUser, HttpStatus.OK);
        } else
            return new ResponseEntity<>("No user Found", HttpStatus.BAD_REQUEST);
    }
    
    
    @GetMapping("{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username) {
        List<User> listOfUser = (List<User>) userService.findByUsername(username);
        if (listOfUser != null) {
            return new ResponseEntity<>(listOfUser, HttpStatus.OK);
        } else
            return new ResponseEntity<>("No user Found", HttpStatus.BAD_REQUEST);
    }
    
    
    @PostMapping("/signup")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        User userSaveResp = userService.save(user);
        if (Objects.nonNull(userSaveResp)) {
            return new ResponseEntity<User>(userSaveResp, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    
    @PutMapping("{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("username") String username) {
        if (username!="" && Objects.nonNull(user)) {
            User userUpdateResp = userService.update(user, username);
            if (Objects.nonNull(userUpdateResp)) {
                return new ResponseEntity<>(userUpdateResp, HttpStatus.CREATED);
            } 
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    
//    @DeleteMapping("{username}")
//    public ResponseEntity<?> deleteByUsername(@PathVariable String username) {
//    	if(userService.deleteByUsername(username) != null)
//    	{
//            return new ResponseEntity<Object>(true, HttpStatus.OK);
//        } 
//        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//    }
    
}