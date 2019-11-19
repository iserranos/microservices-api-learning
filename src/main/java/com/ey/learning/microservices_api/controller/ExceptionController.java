package com.ey.learning.microservices_api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
/*
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exception(Exception exception) {
        System.out.println("ERROR :" +exception);
        return null;
    }*/

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity formatException(MethodArgumentNotValidException exception) {
        System.out.println("Argumento no válido: " + exception);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
