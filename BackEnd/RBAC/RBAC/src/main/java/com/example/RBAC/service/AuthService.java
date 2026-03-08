package com.example.RBAC.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RBAC.dto.AuthResponse;
import com.example.RBAC.dto.LoginRequest;
import com.example.RBAC.dto.RegisterRequest;
import com.example.RBAC.entity.User;
import com.example.RBAC.repository.UserRepository;
import com.example.RBAC.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	public AuthResponse register(RegisterRequest request) {

		User user = new User();

		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());

		userRepository.save(user);

		String token =
				jwtService.generateToken(user.getEmail(), user.getRole());

		return new AuthResponse(token);
	}

	public AuthResponse login(LoginRequest request) {

		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow();

		if (!passwordEncoder.matches(
				request.getPassword(),
				user.getPassword())) {

			throw new RuntimeException("Invalid Password");
		}

		String token =
				jwtService.generateToken(user.getEmail(), user.getRole());

		return new AuthResponse(token);
	}

}
