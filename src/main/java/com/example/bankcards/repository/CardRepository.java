package com.example.bankcards.repository;

import com.example.bankcards.entity.Card;
import com.example.bankcards.entity.enums.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByCardStatus(CardStatus cardStatus);

    Optional<Long> findIdByEncryptedCardNumber(String encryptedCardNumber);


    List<Card> findByCardExpirationDate(LocalDateTime expirationDate);

}
