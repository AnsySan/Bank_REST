package com.example.bankcards.controller;

import com.example.bankcards.service.card.CardService;
import com.example.bankcards.service.transfer.TransferService;
import lombok.RequiredArgsConstructor;
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
}
