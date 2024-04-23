package com.dentalia.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentalia.v1.entity.dto.UserLogin;
import com.dentalia.v1.entity.model.User;
import com.dentalia.v1.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserLogin userLogin) {
        User userFromDB = authService.login(userLogin);
        return ResponseEntity.ok(userFromDB);
    }

}
