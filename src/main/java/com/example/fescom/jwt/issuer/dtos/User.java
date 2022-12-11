package com.example.fescom.jwt.issuer.dtos;


import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data

public class User {

    private UUID id;
    private String username;
    private String password;
    private String email;
    private List<Authority> authorities;

}
