package com.example.bankcards.util.mapper;

import com.example.bankcards.dto.CardResponse;
import com.example.bankcards.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardMapper {

    Card toEntity(CardResponse cardResponse);

    CardResponse toDto(Card card);
}
