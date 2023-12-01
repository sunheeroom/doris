package com.musinsa.coordinator.exception;

public class DbExecutionErrorException extends RuntimeException {
    public DbExecutionErrorException(String message) {
        super(message);
    }
}
