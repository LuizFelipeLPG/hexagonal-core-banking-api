package com.hexagonal_core_banking.banking_api.dto;

public record AccountRequest(
    String bank,
    String branch,
    String accountNumber,
    Double balance,
    String accountHolderId,
    String limit,
    String active

) {
    
}
