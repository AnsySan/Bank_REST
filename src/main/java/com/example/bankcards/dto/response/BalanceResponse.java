package com.example.bankcards.dto.response;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceResponse {

    @NotNull
    private long cadrId;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal balance;
}
