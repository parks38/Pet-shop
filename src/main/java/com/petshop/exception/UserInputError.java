package com.petshop.exception;

public class UserInputError extends IllegalArgumentException{
    public UserInputError(String message) {
        super(message);
    }
}
