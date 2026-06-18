package com.hexagonal_core_banking.banking_hexagon.domain.mapper;

import com.hexagonal_core_banking.banking_hexagon.domain.dto.AccountDTO;
import com.hexagonal_core_banking.banking_hexagon.domain.entity.Account;
import com.hexagonal_core_banking.banking_hexagon.domain.vo.AccountHolderId;
import com.hexagonal_core_banking.banking_hexagon.domain.vo.Limit;

public class AccountMapper {
    public AccountDTO toDTO(Account account) {
        return new AccountDTO(
            account.getAccountId().id(),
            account.getBank(),
            account.getBranch(),
            account.getAccountNumber(),
            account.getBalance(),
            account.getAccountHolderId().id(),
            account.getLimit().toString(),
            account.isActive()
        );
    }

    public Account toEntity(AccountDTO accountDTO) {
        return new Account(
            accountDTO.bank(),
            accountDTO.branch(),
            accountDTO.accountNumber(),
            accountDTO.balance(),
            new AccountHolderId(accountDTO.accountHolderId()),
            toLimit(accountDTO.limit()),
            accountDTO.active()
            );
    }

    private Limit toLimit(String limit) {
        String[] limits = limit.split(",");

        if (limits.length != 3) {
            throw new IllegalArgumentException("Limit must have three values separated by commas.");
        }

        return new Limit(
            Double.parseDouble(limits[0]),
            Double.parseDouble(limits[1]),
            Double.parseDouble(limits[2]));
    }
}