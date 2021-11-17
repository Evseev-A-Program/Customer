package com.example.customer.exception;

public class CustomerAlreadyExistException extends Exception{

    public CustomerAlreadyExistException(String message) {
        super(message);
    }
}
