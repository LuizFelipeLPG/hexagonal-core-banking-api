package com.hexagonal_core_banking.banking_hexagon.port.driven;

import com.hexagonal_core_banking.banking_hexagon.domain.dto.AccountDTO;
import java.util.UUID;

public interface AccountDrivenPort {
    AccountDTO save(AccountDTO accountDTO);
    AccountDTO update(AccountDTO accountDTO);
    AccountDTO findAccountById(UUID id);
    void transfer(UUID from, UUID to, Double amount);
    void credit(UUID id, Double amount);
    void debit(UUID id, Double amount);
    Double getBalance(UUID id);
}