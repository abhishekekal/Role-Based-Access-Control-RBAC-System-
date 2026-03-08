package com.example.RBAC.dto;


import com.example.RBAC.entity.Role;

import lombok.Data;

@Data
public class RegisterRequest {

	private String name;
	private String email;
	private String password;
	private Role role;

}
