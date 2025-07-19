package com.example.bankcards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private boolean isBanned;

}
