package com.ey.learning.microservices_api.service.impl;

import com.ey.learning.microservices_api.controller.AuthController;
import com.ey.learning.microservices_api.model.UserPasswordAuth;
import com.ey.learning.microservices_api.service.AuthService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {


 
    private HashMap<String,String> tokenss = new HashMap<>();
    private HashMap<String,String> refreshTokens = new HashMap<>();

    @Override
    public String addToken(UserPasswordAuth userPasswordAuth) {
        if(userPasswordAuth.getPassword()==null){
            userPasswordAuth.setPassword("");
        }

        if ((userPasswordAuth.getUser() != null && !userPasswordAuth.getUser().isEmpty()) && ( !(userPasswordAuth.getPassword().length() < 6) )) {



            if(tokenss.containsKey(userPasswordAuth.getUser())){
                String token = tokenss.get(userPasswordAuth.getUser());
                String refreshToken = tokenss.get(token);
                System.out.println("Usuario: " + userPasswordAuth.getUser() + "\n"+ "Token: "+ tokenss.get(userPasswordAuth.getUser())+
                        "\n" + "RefreshToken: "+ refreshTokens.get(token));

                String format = String.format("{\"User\":\"%s\", \"token\":\"%s\", \"refreshToken\":\"%s\"}", userPasswordAuth.getUser(),token, refreshToken);



                return format;
            }else{
                String token = RandomStringUtils.randomAlphanumeric(32);
                String refreshToken = RandomStringUtils.randomAlphanumeric(24);
                tokenss.put(userPasswordAuth.getUser(),token);
                refreshTokens.put(token,refreshToken);
                String format = String.format("{\"User\":\"%s\", \"token\":\"%s\", \"refreshToken\":\"%s\"}", userPasswordAuth.getUser(),token, refreshToken);

                System.out.println("Usuario: " + userPasswordAuth.getUser() + "\n"+ "Token: "+ token+
                        "\n" + "RefreshToken: "+ refreshToken);


                return format;
            }






        }

       return null;
    }

    @Override
    public boolean validateToken(String token) {


        return tokenss.containsValue(token);
    }


}
