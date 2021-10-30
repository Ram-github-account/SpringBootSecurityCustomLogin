package com.spring.boot.security.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.boot.security.application.dto.UserRegistrationDto;
import com.spring.boot.security.application.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		System.out.println("UserRegistrationController() constructor : UserRegistrationController class >>>>>>>>>>  ");
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		System.out.println("userRegistrationDto() method : UserRegistrationController class >>>>>>>>>>>>> ");
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		System.out.println("showRegistrationForm() method : UserRegistrationController class >>>>>>>>>>>>>  ");
		return "registration";
	}

	// create handler method- which will handle http post request
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
		System.out.println("registerUserAccount() method : UserRegistrationController class >>>>>>>>>>>>>  ");
		userService.save(userRegistrationDto);
		return "redirect:/registration?success";
	}
}
