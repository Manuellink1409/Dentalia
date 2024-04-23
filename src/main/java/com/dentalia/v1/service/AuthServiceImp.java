package com.dentalia.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dentalia.v1.entity.dto.UserLogin;
import com.dentalia.v1.entity.model.User;
import com.dentalia.v1.exception.InvalidCredentialsException;
import com.dentalia.v1.exception.UserNotFoundException;
import com.dentalia.v1.repository.AuthRepository;

@Service
public class AuthServiceImp implements AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public User login(UserLogin userLogin) {
        User userFromDB = authRepository.findByEmail(userLogin.getEmail());
    if (userFromDB == null) {
        throw new UserNotFoundException("Usuario no encontrado con el correo electrónico: " + userLogin.getEmail());
    }
    if (!userFromDB.getPassword().equals(userLogin.getPassword())) {
        throw new InvalidCredentialsException("Credenciales inválidas para el usuario con correo electrónico: " + userLogin.getEmail());
    }
    return userFromDB;
    }

}
