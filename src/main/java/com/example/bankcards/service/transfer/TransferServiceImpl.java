package com.example.bankcards.service.transfer;

import com.example.bankcards.dto.EncryptedCardNumber;
import com.example.bankcards.dto.request.TransferRequest;
import com.example.bankcards.dto.response.TransferResponse;
import com.example.bankcards.entity.Card;
import com.example.bankcards.entity.Transfer;
import com.example.bankcards.repository.CardRepository;
import com.example.bankcards.repository.TransferRepository;
import com.example.bankcards.util.mapper.TransferMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    private final CardRepository cardRepository;
    private final TransferMapper transferMapper;

    @Override
    public TransferResponse transfer(TransferRequest transferRequest) {


        return null;
    }

    @Override
    public void cancelTransfer(TransferResponse transferResponse) {
        Transfer transfer = transferMapper.toEntity(transferResponse);
        Card card = cardRepository.findById(transferResponse.getFromCardId()).orElseThrow();

        transfer.setFromCard(card);

        cancelTransfer(transferResponse);

    }
}
