package com.example.bankcards.service.transfer;

import com.example.bankcards.dto.request.TransferRequest;
import com.example.bankcards.dto.response.TransferResponse;
import com.example.bankcards.entity.Transfer;

public interface TransferService {
    TransferResponse transfer(TransferResponse transferResponse);

    void cancelTransfer(TransferResponse transferResponse);


}
