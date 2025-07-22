package com.example.bankcards.controller;

import com.example.bankcards.dto.request.LoginRequest;
import com.example.bankcards.dto.request.RegistrationRequestDto;
import com.example.bankcards.dto.response.TokenResponse;
import com.example.bankcards.dto.response.UserResponse;
import com.example.bankcards.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public UserResponse authenticate(RegistrationRequestDto registrationRequestDto) {
        return authenticationService.registration(registrationRequestDto);
    }

    public TokenResponse login(LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    public TokenResponse refreshToken(String refreshToken) {
        return authenticationService.refreshToken(refreshToken);
    }
}
