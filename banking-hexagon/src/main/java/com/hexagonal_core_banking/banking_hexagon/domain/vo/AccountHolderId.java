package com.hexagonal_core_banking.banking_hexagon.domain.vo;

import java.util.UUID;

public record AccountHolderId(UUID id){

    public AccountHolderId {    
    if (id == null) {
        throw new IllegalArgumentException("Account Holder ID cannot be null");
        }
    }

    public AccountHolderId(){
        this(UUID.randomUUID());
    }
}