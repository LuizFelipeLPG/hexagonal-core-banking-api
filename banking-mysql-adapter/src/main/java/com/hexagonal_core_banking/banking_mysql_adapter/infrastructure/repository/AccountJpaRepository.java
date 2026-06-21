package com.hexagonal_core_banking.banking_mysql_adapter.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexagonal_core_banking.banking_mysql_adapter.infrastructure.entity.AccountEntity;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, UUID>{ 

}