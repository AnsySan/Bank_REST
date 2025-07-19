package com.example.bankcards.config;

import com.example.bankcards.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@AllArgsConstructor

public class SecurityConfig {

    private final UserService userService;

}
