package com.example.bankcards.service;

import com.example.bankcards.dto.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDetails loadUserByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    UserResponse getUserById(long id);

    void deleteUser(long id);

    void banUserByIds(long id);
}
