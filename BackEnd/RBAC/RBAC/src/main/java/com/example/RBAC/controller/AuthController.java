package com.example.RBAC.controller;


import org.springframework.web.bind.annotation.*;

import com.example.RBAC.dto.AuthResponse;
import com.example.RBAC.dto.LoginRequest;
import com.example.RBAC.dto.RegisterRequest;
import com.example.RBAC.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/register")
	public AuthResponse register(@RequestBody RegisterRequest request) {
		return authService.register(request);
	}

	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginRequest request) {
		return authService.login(request);
	}

}
