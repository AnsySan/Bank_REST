package com.example.bankcards.service.jwt;

import com.example.bankcards.dto.response.UserResponse;
import com.example.bankcards.entity.User;

public interface JwtService {

    UserResponse generateToken(User user);

    UserResponse regenerateToken(String token);
}
