package com.hexagonal_core_banking.banking_hexagon.domain.vo;

import com.hexagonal_core_banking.banking_hexagon.domain.exception.BankingValidationException;

public record Limit(
    Double dailyTransactionLimit,
    Double dailyTransferLimit,
    Double dailyWithdrawLimit

){
    public Limit {
        validate(dailyTransactionLimit, dailyTransferLimit, dailyWithdrawLimit);
    }

    private void validate(Double dailyTransactionLimit, Double dailyTransferLimit, Double dailyWithdrawLimit){
        StringBuilder sb = new StringBuilder();

        if(dailyTransactionLimit < 0){
            sb.append("Daily Transaction Limit must be greater than or equal to zero. ");
        }

        if(dailyTransferLimit < 0){
            sb.append("Daily Transfer Limit must be greater than or equal to zero. ");
        }

        if(dailyWithdrawLimit < 0){
            sb.append("Daily Withdraw Limit must be greater than or equal to zero. ");
        }
        

        BankingValidationException.when(!sb.isEmpty(), sb.toString());
    }

}