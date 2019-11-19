package com.ey.learning.microservices_api.service.impl;

import com.ey.learning.microservices_api.model.UserPasswordAuth;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl {


    private List<String> tokens = new ArrayList<>();

    public String addToken(UserPasswordAuth userPasswordAuth) {
        if (!"demo".equals(userPasswordAuth.getUser()) || !"!p@s5w0r?".equals(userPasswordAuth.getPassword())) {
            return null;
        }

        String token = RandomStringUtils.randomAlphanumeric(32);
        String refreshToken = RandomStringUtils.randomAlphanumeric(24);
        System.out.println(token);
        System.out.println(refreshToken);
        String format = String.format("{\"token\":\"%s\", \"refreshToken\":\"%s\"}", token, refreshToken);
        tokens.add(token);
        return format;
    }

    public boolean validateToken(String token) {
        return tokens.contains(token);
    }



}
