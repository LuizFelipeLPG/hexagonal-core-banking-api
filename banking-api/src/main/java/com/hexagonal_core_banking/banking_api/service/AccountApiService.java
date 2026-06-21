package com.hexagonal_core_banking.banking_api.service;

import java.util.List;
import java.util.UUID;

import com.hexagonal_core_banking.banking_hexagon.domain.dto.AccountDTO;

public interface AccountApiService {
    AccountDTO save(AccountDTO accountDTO);
    AccountDTO update(AccountDTO accountDTO);
    List<AccountDTO> findAll();
    AccountDTO findAccountById(UUID id);
    void transfer(UUID from, UUID to, Double amount);
    void credit(UUID id, Double amount);
    void debit(UUID id, Double amount);
    Double getBalance(UUID id);

}



