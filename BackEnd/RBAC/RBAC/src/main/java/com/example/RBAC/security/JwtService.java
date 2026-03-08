package com.example.RBAC.security;


import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.RBAC.entity.Role;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private final String SECRET =
			"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYmhpQGdtYWlsLmNvbSIsImlhdCI6MTc3Mjg3Mjk4NywiZXhwIjoxNzcyOTU5Mzg3fQ.sxU805oF40gEJzbJkBHhgcEt_2NFZyC6TgtL_dEVi8I";

	private Key getKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}

	public String generateToken(String email, Role role) {

		return Jwts.builder()
				.setSubject(email)
				.claim("role", role.name())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 86400000))
				.signWith(getKey())
				.compact();
	}

	public Claims extractClaims(String token) {

		return Jwts.parserBuilder()
				.setSigningKey(getKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	public String extractEmail(String token) {
		return extractClaims(token).getSubject();
	}

}
