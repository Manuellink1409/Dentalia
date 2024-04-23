package com.dentalia.v1.service;

import com.dentalia.v1.entity.dto.UserLogin;
import com.dentalia.v1.entity.model.User;

public interface AuthService {

    User login(UserLogin userLogin);

}
