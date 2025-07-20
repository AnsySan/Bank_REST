package com.example.bankcards.service.card;

import com.example.bankcards.dto.response.BalanceResponse;
import com.example.bankcards.dto.response.CardResponse;
import com.example.bankcards.entity.enums.CardStatus;

public interface CardService {

    CardResponse create(Long ownerId);

    CardResponse changeStatus(Long ownerId, CardStatus cardStatus);

    void deleteCard(Long cardId);

    CardResponse findCardById(Long cardId);

    CardResponse findCardByOwnerId(Long ownerId);

    CardResponse blockCard(Long cardId);

    BalanceResponse getBalance(Long cardId);

}
