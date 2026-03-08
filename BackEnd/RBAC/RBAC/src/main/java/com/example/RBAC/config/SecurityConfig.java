package com.example.RBAC.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.RBAC.security.JwtFilter;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	private JwtFilter jwtFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
		.csrf(x -> x.disable())
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/auth/**","/api/public/**").permitAll()
				.requestMatchers("/api/admin/**").hasRole("ADMIN")
				.requestMatchers("/api/user/**").hasRole("USER")
				.anyRequest().authenticated()
		)
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
