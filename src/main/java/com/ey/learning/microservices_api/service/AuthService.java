package com.ey.learning.microservices_api.service;

import com.ey.learning.microservices_api.model.UserPasswordAuth;

public interface AuthService {

    String addToken(UserPasswordAuth userPasswordAuth);

    boolean validateToken(String token);
}
