package com.jkwiatko.adminappbackend.security.auth;

import lombok.Data;

@Data
public class UserCredentials {
    private String email;
    private String password;
}

