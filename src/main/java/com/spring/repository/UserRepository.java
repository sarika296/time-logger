package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Log;

public interface UserRepository extends JpaRepository<Log, Integer> {

}