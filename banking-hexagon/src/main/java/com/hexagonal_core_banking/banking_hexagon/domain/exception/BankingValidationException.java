package com.hexagonal_core_banking.banking_hexagon.domain.exception;

public class BankingValidationException extends RuntimeException {
    public BankingValidationException(String message) {
        super(message);
    }

    public static void when(boolean condition, String message) {
        if (condition) {
            throw new BankingValidationException(message);
        }
    }
}