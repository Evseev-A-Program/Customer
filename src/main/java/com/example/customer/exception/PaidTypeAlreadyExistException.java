package com.example.customer.exception;

public class PaidTypeAlreadyExistException extends Exception{
    public PaidTypeAlreadyExistException(String message) {
        super(message);
    }
}
