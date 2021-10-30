package com.spring.boot.security.application.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.boot.security.application.dto.UserRegistrationDto;
import com.spring.boot.security.application.model.User;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);

}
