package com.ey.learning.microservices_api.controller;

import com.ey.learning.microservices_api.model.Token;
import com.ey.learning.microservices_api.model.UserPasswordAuth;
import com.ey.learning.microservices_api.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v0/auth", produces = {"application/json"}, path = "/api/v0/auth")
public class AuthController {

    private final AuthServiceImpl authService;

    @Autowired
    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping("/validate")
    public ResponseEntity validate(@RequestBody Token token) {
        return authService.validateToken(token.getToken()) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping
    public ResponseEntity<String> auth(@RequestBody UserPasswordAuth userPasswordAuth) {

        String token = authService.addToken(userPasswordAuth);
        if (token != null) {
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
