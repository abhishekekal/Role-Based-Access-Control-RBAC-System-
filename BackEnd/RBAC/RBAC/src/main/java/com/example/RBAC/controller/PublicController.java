package com.example.RBAC.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "http://localhost:5173")
public class PublicController {

	@GetMapping
	public String publicApi() {
		return "Public API";
	}

}