package com.example.bankcards.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private boolean isBanned;

}
