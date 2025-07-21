package com.example.bankcards.dto.request;

import com.example.bankcards.entity.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardTypeRequest {

    private Long id;

    private CardType cardType;
}
