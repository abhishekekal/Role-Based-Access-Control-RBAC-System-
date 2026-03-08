package com.example.RBAC.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public String userApi() {
		return "User Content";
	}

}
