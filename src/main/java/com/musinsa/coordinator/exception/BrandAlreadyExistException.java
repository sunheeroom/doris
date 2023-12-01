package com.musinsa.coordinator.exception;

public class BrandAlreadyExistException extends IllegalArgumentException {

    public BrandAlreadyExistException(String s) {
        super(s);
    }
}
