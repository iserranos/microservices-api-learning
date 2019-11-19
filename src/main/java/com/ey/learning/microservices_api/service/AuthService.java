package com.ey.learning.microservices_api.service;

import com.ey.learning.microservices_api.model.UserPasswordAuth;

public interface AuthService {

    public String addToken(UserPasswordAuth userPasswordAuth);
    public  boolean validateToken(String token);
}
