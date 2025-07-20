package com.example.bankcards.dto;

import com.example.bankcards.entity.TransferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferResponse {

    private Long id;

    private Long fromCardId;

    private Long toCardId;

    private BigDecimal amount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private TransferStatus status;
}
