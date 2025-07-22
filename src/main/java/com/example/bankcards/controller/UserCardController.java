package com.example.bankcards.controller;

import com.example.bankcards.dto.filter.CardFilter;
import com.example.bankcards.dto.request.CardTypeRequest;
import com.example.bankcards.dto.response.BalanceResponse;
import com.example.bankcards.dto.response.CardResponse;
import com.example.bankcards.dto.response.TransferResponse;
import com.example.bankcards.entity.enums.CardStatus;
import com.example.bankcards.repository.UserRepository;
import com.example.bankcards.service.card.CardService;
import com.example.bankcards.service.transfer.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/user/cards")
@PreAuthorize("hasRole('USER')")
public class UserCardController {
    private final CardService cardService;
    private final TransferService transferService;
    private final UserRepository userRepository;

    public CardResponse createCard(Long userId, CardTypeRequest cardTypeRequest) {
        return cardService.create(userId, cardTypeRequest);
    }

    public CardResponse setCardStatus(Long id, CardStatus cardStatus) {
        return cardService.changeStatus(id, cardStatus);
    }

    public void deleteCard(Long id) {
        cardService.deleteCard(id);
    }

    public CardResponse findCardById(Long cardId){
        return cardService.findCardById(cardId);
    }

    public CardResponse findCardByOwnerId(Long ownerId){
        return cardService.findCardByOwnerId(ownerId);
    }

    public CardResponse blockCard(Long cardId){
        return cardService.blockCard(cardId);
    }
    public BalanceResponse getBalance(Long userId){
        return cardService.getBalance(userId);
    }

    public TransferResponse createTransfer(TransferResponse transferResponse) {
        return transferService.transfer(transferResponse);
    }

    public Page<CardResponse> getCards(Integer offset, Integer limit){
        CardFilter cardFilter = new CardFilter(offset, limit);
        return cardService.getAllCards(cardFilter);
    }
}
