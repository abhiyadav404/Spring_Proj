package com.abhi.springboot.service;

import com.abhi.springboot.model.User;

public interface UserService {
    public User createUser(User user);
    public boolean checkEmail(String email);
}
