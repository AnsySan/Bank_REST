package com.example.bankcards.util.mapper;

import com.example.bankcards.dto.TransferResponse;
import com.example.bankcards.entity.Transfer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransferMapper {

    @Mapping(source = "fromCard.id", target = "fromCardId")
    @Mapping(source = "toCard.id", target = "toCardId")
    TransferResponse toDto(Transfer transfer);

    @Mapping(target = "fromCard", ignore = true)
    @Mapping(target = "toCard", ignore = true)
    Transfer toEntity(TransferResponse transferResponse);
}
