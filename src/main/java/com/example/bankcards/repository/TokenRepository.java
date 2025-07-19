package com.example.bankcards.repository;

import com.example.bankcards.entity.Token;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Long> {
}
