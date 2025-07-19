package com.example.bankcards.repository;

import com.example.bankcards.entity.Card;
import com.example.bankcards.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByCardStatus(Status status);

    List<Card> findByCardExpirationDate(LocalDateTime expirationDate);

}
