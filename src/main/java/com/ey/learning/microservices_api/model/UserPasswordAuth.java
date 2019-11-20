package com.ey.learning.microservices_api.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserPasswordAuth {

    @NotNull
    @NotEmpty
    @NotBlank
    private String user;

    @NotNull
    @NotEmpty
    @NotBlank
    @Min(6)
    private String password;

}
