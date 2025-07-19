package com.example.bankcards.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cadrs")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cardNumber;

    @ManyToOne
    private User owner;

    private Status status;

    private LocalDate expirationDate;

    private BigDecimal balance = BigDecimal.valueOf(0.00);
}
