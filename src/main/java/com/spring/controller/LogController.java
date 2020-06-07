package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.model.Log;
import com.spring.service.LogService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/logs")
public class LogController {
	
	LocalTime localTime;
	LocalDate localDate;
	
    @Autowired
    LogService logService;
    
    @GetMapping
    public ResponseEntity<?> getAllLog() {
        List<Log> listOfLog = logService.fetchAll();
        if (listOfLog != null) {
            return new ResponseEntity<>(listOfLog, HttpStatus.OK);
        } else
            return new ResponseEntity<>("No Log Found", HttpStatus.BAD_REQUEST);
    }
    
    
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
    	Log logSearchResp = logService.findById(id);
        if(logSearchResp != null) {
            return new ResponseEntity<Object>(logSearchResp, HttpStatus.OK);
        } 
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
    

    @PostMapping
    public ResponseEntity<?> addLog(@RequestBody Log log) {
    	log.setTime(localTime.now().toString());
    	log.setDate(localDate.now().toString());
        Log logSaveResp = logService.save(log);
        if (Objects.nonNull(logSaveResp)) {
            return new ResponseEntity<Log>(logSaveResp, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @PutMapping("{id}")
    public ResponseEntity<?> updateLog(@PathVariable("id") Integer id) {
        if (id > 0) {
        	Log logSearchResp = logService.findById(id);
        	long d = Duration.between(localTime.parse(logSearchResp.getTime()), localTime.now()).getSeconds();
        	if(d<0) {
        		d = d+86400;
        	}
			logSearchResp.setCompleted(true);
			logSearchResp.setDuration(d/60);  
        	
            Log logUpdateResp = logService.update(logSearchResp, id);
            if (Objects.nonNull(logUpdateResp)) {
                return new ResponseEntity<>(logUpdateResp, HttpStatus.CREATED);
            } 
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteLog(@PathVariable("id") Integer id) {
        if (id < 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else if (logService.deleteById(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}