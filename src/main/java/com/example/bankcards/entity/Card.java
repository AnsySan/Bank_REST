package com.example.bankcards.entity;

import com.example.bankcards.entity.enums.CardStatus;
import com.example.bankcards.entity.enums.CardType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    private CardStatus cardStatus;

    private LocalDateTime expirationDate;

    private CardType cardType;

    private boolean isDeleted;

    private BigDecimal balance = BigDecimal.valueOf(0.00);
}
