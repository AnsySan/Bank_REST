package com.example.bankcards.controller;

import com.example.bankcards.dto.filter.UserFilter;
import com.example.bankcards.dto.request.RegistrationRequestDto;
import com.example.bankcards.dto.response.UserResponse;
import com.example.bankcards.service.authentication.AuthenticationService;
import com.example.bankcards.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/admin/user")
@PreAuthorize("hasRole('ADMIN')")
public class AdminUserController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    public UserResponse create(RegistrationRequestDto registrationRequestDto) {
        return authenticationService.registration(registrationRequestDto);
    }

    public void delete(Long userId) {
        userService.deleteUser(userId);
    }

    public UserResponse getUser(Long userId) {
        return userService.getUserById(userId);
    }

    public Page<UserResponse> AllUsers(Integer offset, Integer limit) {
        UserFilter userFilter = new UserFilter(offset, limit);
        return userService.getAllUsers(userFilter);
    }
}
