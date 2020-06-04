package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
	
}