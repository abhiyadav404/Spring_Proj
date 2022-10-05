package com.abhi.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.abhi.springboot.model.User;
import com.abhi.springboot.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
    @GetMapping("/")
	public String index() {
		return "index";
	}
    
    @GetMapping("/signin")
   	public String login() {
   		return "login";
   	}
    
    @GetMapping("/register")
   	public String register() {
   		return "register";
   	}
    
    @PostMapping("/createUser")
    public String createuser(@ModelAttribute User user, HttpSession session) {
    	
    	boolean f = userService.checkEmail(user.getEmail());
    	if(f) {
    		session.setAttribute("msg", "Email id already exists...");
    	}
    	else
    	{
    	User userdtls=userService.createUser(user);
    	
    	if(userdtls!=null)
    		session.setAttribute("msg", "Registered Successfully...");
    	else
    		session.setAttribute("msg", "Error on Server Side..");
    	}
    	return "redirect:/register";
    
    }
}
