package com.hexagonal_core_banking.banking_h2_adapter.infrastructure.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    private UUID accountId;
    @NotNull(message = "Bank cannot be null")
    private String bank;
    @NotNull(message = "Branch cannot be null")
    private String branch;
    @NotNull(message = "Account number cannot be null")
    private String accountNumber;
    private Double balance;
    @NotNull(message = "Account holder ID cannot be null")
    @Column(name = "account_holder_id")
    private UUID accountHolderId;
    @NotNull(message = "Limits cannot be null")
    private String limits;
    @Column(name = "is_active", nullable = false)
    private boolean active = true;

}