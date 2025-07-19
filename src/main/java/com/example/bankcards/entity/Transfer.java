package com.example.bankcards.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Card fromCard;

    private Card toCard;

    private BigDecimal amount;

    private TransferStatus

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
