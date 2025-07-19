package com.example.bankcards.service;

import com.example.bankcards.dto.BalanceResponse;
import com.example.bankcards.dto.CardResponse;
import com.example.bankcards.entity.Status;

public interface CardService {

    CardResponse create(Long ownerId);

    CardResponse changeStatus(Long ownerId, Status status);

    void deleteCard(Long cardId);

    CardResponse findCardById(Long cardId);

    CardResponse findCardByOwnerId(Long ownerId);

    CardResponse blockCard(Long cardId);

    BalanceResponse getBalance(Long cardId);

}
