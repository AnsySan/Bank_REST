package com.example.bankcards.controller;

import com.example.bankcards.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
}
