package com.abhi.springboot.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abhi.springboot.model.User;
import com.abhi.springboot.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
    
	@Autowired
     private UserRepository userRepository;	
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email=p.getName();
		User user=userRepository.findByEmail(email);
		m.addAttribute("user", user);
	}
	
	@GetMapping("/")
	public String home() {
		return "user/home";
	}
}
