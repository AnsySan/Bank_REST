package com.example.bankcards.service.transfer;

import com.example.bankcards.dto.request.TransferRequest;
import com.example.bankcards.dto.response.TransferResponse;

public interface TransferService {
    TransferResponse transfer(TransferRequest transferRequest);

    void cancelTransfer(TransferResponse transferResponse);


}
