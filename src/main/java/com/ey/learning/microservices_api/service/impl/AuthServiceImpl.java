package com.ey.learning.microservices_api.service.impl;

import com.ey.learning.microservices_api.model.UserPasswordAuth;
import com.ey.learning.microservices_api.service.AuthService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthServiceImpl implements AuthService {

    private HashMap<String, String> userToken = new HashMap<>();

    @Override
    public String addToken(UserPasswordAuth userPasswordAuth) {

        String user = userPasswordAuth.getUser();
        String refreshToken = generateToken(24);
        String token;
        if (userToken.containsKey(user)) {
            token = userToken.get(user);
        } else {
            token = generateToken(32);
            userToken.put(user, token);
        }
        return String.format("{\"user\":\"%s\", \"token\":\"%s\", \"refreshToken\":\"%s\"}", user, token, refreshToken);
    }

    @Override
    public boolean validateToken(String token) {
        return userToken.containsValue(token);
    }

    private String generateToken(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }


}
