package com.ey.learning.microservices_api.model;

import lombok.Data;

@Data
public class UserPasswordAuth {

    private String user;
    private String password;
}
