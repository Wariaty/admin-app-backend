package com.jkwiatko.adminappbackend.security.jwt;

import lombok.Data;

import java.util.Date;

@Data
public class Jwt {
    private final String token;
    private final Date expirationDate;
}