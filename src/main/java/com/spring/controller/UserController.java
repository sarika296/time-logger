package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.spring.model.User;
import com.spring.service.UserService;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	private static String secretKey = "keyboardCat";
	
	public static byte[] getSHA(String password) throws NoSuchAlgorithmException 
	{ 
		password.concat(secretKey);
		MessageDigest md = MessageDigest.getInstance("SHA-256"); 
		return md.digest(password.getBytes(StandardCharsets.UTF_8)); 
	} 
	
	public static String toHexString(byte[] hash) 
    { 
        BigInteger number = new BigInteger(1, hash);  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
        return hexString.toString();  
    }
	
	@SuppressWarnings("deprecation")
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOrigins("*")
	                    .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
	                    .allowedHeaders("*", "Access-Control-Allow-Headers", "origin", "Content-type", "accept", "x-requested-with", "x-requested-by")
	                    .allowCredentials(true);
	        }
	    };
	}

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
    
    
    @PostMapping(path="/login")
    public ResponseEntity<?> findByUsername(@RequestBody User user) throws NoSuchAlgorithmException {
    	List<User> listOfUser = (List<User>) userService.fetchAll();
        for (User userObj : listOfUser) {
            if(userObj.getUsername().equals(user.getUsername())) {
            	if(userObj.getPassword().equals(toHexString(getSHA(user.getPassword().concat(secretKey))))) {
            		return new ResponseEntity<>(userObj,HttpStatus.OK);
            	}
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    
    @PostMapping(path="/signup", consumes = {
    		MediaType.APPLICATION_XML_VALUE,
    		MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<?> addUser(@RequestBody User user) throws NoSuchAlgorithmException {
    	user.setPassword(toHexString(getSHA(user.getPassword().concat(secretKey))));
        User userSaveResp = userService.save(user);
        if (Objects.nonNull(userSaveResp)) {
            return new ResponseEntity<User>(userSaveResp, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}