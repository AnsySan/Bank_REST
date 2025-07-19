package com.example.bankcards.service;

import com.example.bankcards.dto.UserResponse;
import com.example.bankcards.entity.User;

public interface JwtService {

    UserResponse generateToken(User user);

    UserResponse regenerateToken(String token);
}
