package com.hexagonal_core_banking.banking_h2_adapter.infrastructure.repository;

import com.hexagonal_core_banking.banking_h2_adapter.infrastructure.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, UUID> {
    
}