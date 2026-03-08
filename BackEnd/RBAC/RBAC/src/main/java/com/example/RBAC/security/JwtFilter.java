package com.example.RBAC.security;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.RBAC.*;
import com.example.RBAC.service.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer ")) {

			String token = header.substring(7);

			String email = jwtService.extractEmail(token);

			var userDetails = userDetailsService.loadUserByUsername(email);

			var authToken =
					new UsernamePasswordAuthenticationToken(
							userDetails,
							null,
							userDetails.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authToken);
		}

		filterChain.doFilter(request, response);
	}

}
