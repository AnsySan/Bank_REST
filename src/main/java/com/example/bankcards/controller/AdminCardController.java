package com.example.bankcards.controller;

import com.example.bankcards.dto.filter.CardFilter;
import com.example.bankcards.dto.request.CardTypeRequest;
import com.example.bankcards.dto.response.CardResponse;
import com.example.bankcards.entity.enums.CardStatus;
import com.example.bankcards.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/admin/cards")
@PreAuthorize("hasRole('ADMIN')")
public class AdminCardController {
    private final CardService cardService;

    public CardResponse createCard(Long ownerId, CardTypeRequest cardTypeRequest) {
        return cardService.create(ownerId, cardTypeRequest);
    }

    public CardResponse changeCardStatus(Long cardId, CardStatus cardStatus) {
        return cardService.changeStatus(cardId, cardStatus);
    }

    public void deleteCard(Long cardId) {
        cardService.deleteCard(cardId);
    }

    public CardResponse getCard(Long cardId) {
        return cardService.findCardById(cardId);
    }

    public CardResponse blockCard(Long cardId){
        return cardService.blockCard(cardId);
    }

    public Page<CardResponse> getAllCards(Integer offset, Integer limit) {
        CardFilter  cardFilter = new CardFilter(offset, limit);
        return cardService.getAllCards(cardFilter);
    }
}
