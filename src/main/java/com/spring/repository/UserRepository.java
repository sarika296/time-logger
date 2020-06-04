package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> existsByUsername(String username);
	
	public List<User> findByUsername(String username);

	public List<User> deleteByUsername(String username);
	
}