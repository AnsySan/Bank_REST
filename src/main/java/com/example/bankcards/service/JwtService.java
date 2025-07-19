package com.example.bankcards.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JwtService {
    <T> T extractClaims(String token, Function<Claims, T> claimsResolver);

    String extractUsername(String token);

    boolean validateToken(String token);

    Claims extractAllClaims(String token);

}
