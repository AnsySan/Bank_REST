package com.example.bankcards.dto.response;

import com.example.bankcards.entity.enums.CardStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class CardResponse {

    @NotNull
    private long id;

    @NotNull
    private int cardTypeCode;

    @NotNull
    @Pattern(regexp = "^(\\*{4} ?)*\\d{4}$")
    private String cardNumber;

    @NotNull
    private Long ownerId;

    @NotNull
    private LocalDateTime expirationDate;

    @NotNull
    private boolean isDeleted;

    @NotNull
    private CardStatus cardStatus;

    @NotNull
    @DecimalMin(value = "0.00")
    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;
}
