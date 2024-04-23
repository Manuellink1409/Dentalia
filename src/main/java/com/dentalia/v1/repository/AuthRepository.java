package com.dentalia.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalia.v1.entity.model.User;


public interface AuthRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
