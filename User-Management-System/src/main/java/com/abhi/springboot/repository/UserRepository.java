package com.abhi.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
   public boolean existsByEmail(String email);
   public User findByEmail(String email);
}
