package com.example.exception;

public class AccountOwnershipException extends RuntimeException {

    public AccountOwnershipException(String message) {
        super(message);
    }
}
