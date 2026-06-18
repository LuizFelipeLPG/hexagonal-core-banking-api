package com.hexagonal_core_banking.banking_hexagon.domain.entity;

import com.hexagonal_core_banking.banking_hexagon.domain.exception.BankingValidationException;
import com.hexagonal_core_banking.banking_hexagon.domain.vo.Limit;
import com.hexagonal_core_banking.banking_hexagon.domain.vo.AccountHolderId;
import com.hexagonal_core_banking.banking_hexagon.domain.vo.AccountId;

public class Account {
    private AccountId accountId;
    private final String bank;
    private final String branch;
    private final String accountNumber;
    private Double balance = 0.0;
    private final AccountHolderId accountHolderId;
    private Limit limit;
    private boolean active;

    public Account(String bank, String branch, String accountNumber, Double balance, AccountHolderId accountHolderId, Limit limit, boolean active) {
        validate(bank, branch, accountNumber, balance, accountHolderId, limit);
        this.bank = bank;
        this.branch = branch;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderId = accountHolderId;
        this.limit = limit;
        this.active = active;
    }

    private void validate(String bank, String branch, String accountNumber, Double balance, AccountHolderId accountHolderId, Limit limit) {
        StringBuilder sb = new StringBuilder();

        final int ACCOUNT_NUMBER_LENGTH = 8;
        final int BRANCH_NUMBER_LENGTH = 5;
        final int BANK_NUMBER_LENGTH = 3;   

        if (bank == null|| bank.length() != BANK_NUMBER_LENGTH) {
            sb.append("bank must be " + BANK_NUMBER_LENGTH + " characters long");
        }

        if (branch == null || branch.length() != BRANCH_NUMBER_LENGTH) {
            sb.append("branch must be " + BRANCH_NUMBER_LENGTH + " characters long");
        }

        if (accountNumber == null || accountNumber.length() != ACCOUNT_NUMBER_LENGTH) {
            sb.append("accountNumber must be " + ACCOUNT_NUMBER_LENGTH + " characters long");
        }

        if (balance == null || balance  < 0) {
            sb.append("balance must be greater than or equal to zero");
        }

        if (accountHolderId == null) {
            sb.append("accountHolderId cannot be null");
        }

        if (limit == null) {
            sb.append("limit cannot be null");
        }

        BankingValidationException.when(!sb.isEmpty(), sb.toString().trim());
    }

    public void credit(Double amount) {
        this.balance += amount;
    }

    public void debit(Double amount) {
        this.balance -= amount;
    }

    public void transfer(Account account, Double amount) {
        this.balance -= amount;
        account.balance += amount;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public String getBank() {
        return bank;
    }

    public String getBranch() {
        return branch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public AccountHolderId getAccountHolderId() {
        return accountHolderId;
    }

    public Limit getLimit() {
        return limit;
    }

    public boolean isActive() {
        return active;
    }
}