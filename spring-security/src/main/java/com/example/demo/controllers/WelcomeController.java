package com.example.demo.controllers;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path="/api/v1")
public class WelcomeController {
	
	@GetMapping(path="/students")
	public String getStudent() {
		return "Student suresh";
	}
	@GetMapping(path="/teachers")
	public String getTeachers(Principal principal) {
		System.out.println("Accessed by = "+principal.getName());
		return "Teacher Tom";
	}
	@GetMapping(path="/staff")
	public String getStaff(Principal principal) {
		System.out.println("Accessed by = "+principal.getName());
		return "Staff Sammy";
	}
	

}
