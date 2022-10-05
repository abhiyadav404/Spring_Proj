package com.abhi.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.abhi.springboot.model.User;
import com.abhi.springboot.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
    
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public User createUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		return userRepository.save(user);
	}
	@Override
	public boolean checkEmail(String email) {
		
		return userRepository.existsByEmail(email);
	}

}
