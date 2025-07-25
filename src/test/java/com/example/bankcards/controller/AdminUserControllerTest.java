package com.example.bankcards.controller;

import com.example.bankcards.dto.filter.UserFilter;
import com.example.bankcards.dto.request.RegistrationRequestDto;
import com.example.bankcards.dto.response.UserResponse;
import com.example.bankcards.service.authentication.AuthenticationService;
import com.example.bankcards.service.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class AdminUserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Mock
    private AuthenticationService authenticationService;

    private ObjectMapper objectMapper;

    @InjectMocks
    private AdminUserController adminUserController;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        mockMvc = MockMvcBuilders.standaloneSetup(adminUserController).build();
    }

    @Test
    void createUser_ShouldReturnCreated() throws Exception {
        RegistrationRequestDto request = new RegistrationRequestDto();
        request.setUsername("admin");
        request.setPassword("password");
        request.setEmail("admin@example.com");

        UserResponse response = new UserResponse();
        response.setId(1L);
        response.setUsername("admin");
        response.setPassword("password");
        response.setEmail("admin@example.com");
        response.setPhone("+123123123123");

        Mockito.when(authenticationService.registration(any(RegistrationRequestDto.class))).thenReturn(response);

        mockMvc.perform(post("/v1/api/admin/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.username").value("admin"));
    }

    @Test
    void deleteUser_ShouldReturnNoContent() throws Exception {
        doNothing().when(userService).deleteUser(1L);

        mockMvc.perform(delete("/v1/api/admin/user/1"))
                .andExpect(status().isNoContent());

        verify(userService).deleteUser(1L);
    }

    @Test
    void getUserById_ShouldReturnUser() throws Exception {
        UserResponse response = new UserResponse();
        response.setId(1L);
        response.setUsername("admin");

        Mockito.when(userService.getUserById(1L)).thenReturn(response);

        mockMvc.perform(get("/v1/api/admin/user/get/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.username").value("admin"));
    }

    @Test
    void getAllUsers_ShouldReturnUserPage() throws Exception {
        UserResponse user = new UserResponse();
        user.setId(1L);
        user.setUsername("admin");

        Mockito.when(userService.getAllUsers(any(UserFilter.class)))
                .thenReturn(new PageImpl<>(List.of(user), PageRequest.of(0, 10), 1));

        mockMvc.perform(get("/v1/api/admin/user/get?offset=0&limit=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1L))
                .andExpect(jsonPath("$.content[0].username").value("admin"));
    }
}