package com.example.bankcards.util.mapper;

import com.example.bankcards.dto.response.CardResponse;
import com.example.bankcards.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardMapper {

    @Mapping(target = "number", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "owner", source = "ownerId")
    @Mapping(source = "number", target = "cardMask")
    @Mapping(source = "owner.id", target = "ownerId")
    Card toEntity(CardResponse cardResponse);

    @Mapping(source = "number", target = "cardMask")
    @Mapping(source = "owner.id", target = "ownerId")
    CardResponse toDto(Card card);
}
