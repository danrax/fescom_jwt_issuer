package com.example.fescom.jwt.issuer.dtos;

import lombok.Data;

@Data
public class UserDto {

    private String email;
    private String name;
    private String lastName;
    private String validationToken;
}
