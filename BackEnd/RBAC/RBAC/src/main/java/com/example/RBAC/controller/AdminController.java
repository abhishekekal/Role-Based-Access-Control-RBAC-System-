package com.example.RBAC.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

	@GetMapping
	public String adminApi() {
		return "Admin Content";
	}

}
