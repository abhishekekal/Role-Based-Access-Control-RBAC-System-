package com.example.RBAC.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RBAC.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);

}