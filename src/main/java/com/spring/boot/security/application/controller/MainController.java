package com.spring.boot.security.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}

	@GetMapping("/index")
	public String welcome() {
		return "index";
	}
}
