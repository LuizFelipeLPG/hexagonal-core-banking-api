package com.hexagonal_core_banking.banking_mysql_adapter.application.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.hexagonal_core_banking.banking_hexagon.domain.dto.AccountDTO;
import com.hexagonal_core_banking.banking_mysql_adapter.infrastructure.entity.AccountEntity;

@Component("accountMapperMysql")
public class AccountMapper{    
    public AccountEntity toEntity(AccountDTO accountDTO) {
        AccountEntity entity = new AccountEntity();
        BeanUtils.copyProperties(accountDTO, entity);
        return entity;
    }   

    public AccountDTO toDTO(AccountEntity entity) {
        return new AccountDTO(
            entity.getAccountId(),
            entity.getBank(),
            entity.getBranch(),
            entity.getAccountNumber(),
            entity.getBalance(),
            entity.getAccountHolderId(),
            entity.getLimits(),
            entity.isActive()
        );
    }    
}