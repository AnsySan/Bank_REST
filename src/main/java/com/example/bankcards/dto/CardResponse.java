package com.example.bankcards.dto;

import com.example.bankcards.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardResponse {
    private long id;
    private String cardNumber;
    private long ownerId;
    private LocalDateTime expirationDate;
    private Status status;
    private BigDecimal balance;
}
