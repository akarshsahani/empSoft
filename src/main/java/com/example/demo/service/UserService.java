package com.example.demo.service;

import com.example.demo.entity.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.demo.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto userRegostrationDto);

}
