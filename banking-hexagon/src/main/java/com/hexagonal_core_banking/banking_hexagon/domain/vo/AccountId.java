package com.hexagonal_core_banking.banking_hexagon.domain.vo;

import java.util.UUID;

public record AccountId(UUID id) {
    public AccountId {
        if (id == null) {
            throw new IllegalArgumentException("Account ID cannot be null");
        }
    }

    public AccountId(){
        this(UUID.randomUUID());
    }
}