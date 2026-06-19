package com.hexagonal_core_banking.banking_hexagon.infrastructure.service;

import com.hexagonal_core_banking.banking_hexagon.port.driver.AccountDriverPort;
import com.hexagonal_core_banking.banking_hexagon.infrastructure.AccountRepository;
import com.hexagonal_core_banking.banking_hexagon.domain.dto.AccountDTO;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountDriverPort {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        return accountRepository.save(accountDTO);
    }

    @Override
    public AccountDTO update(AccountDTO accountDTO) {
        AccountDTO account = accountRepository.findAccountById(accountDTO.accountId());
        if (account != null) {
            return accountRepository.update(accountDTO);
        }

        throw new IllegalArgumentException("Account not found");
    }

    @Override
    public List<AccountDTO> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public AccountDTO findAccountById(UUID id) {
        AccountDTO account = accountRepository.findAccountById(id);
        if (account != null) {
            return account;
        }

        throw new IllegalArgumentException("Account not found");
    }

    @Override
    public void transfer(UUID from, UUID to, Double amount) {
        accountRepository.transfer(from, to, amount);
    }

    @Override
    public void credit(UUID id, Double amount) {
        accountRepository.credit(id, amount);
    }

    @Override
    public void debit(UUID id, Double amount) {
        accountRepository.debit(id, amount);
    }

    @Override
    public Double getBalance(UUID id) {
        return accountRepository.getBalance(id);
    }

}