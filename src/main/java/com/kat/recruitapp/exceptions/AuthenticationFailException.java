package com.kat.recruitapp.exceptions;

public class AuthenticationFailException extends RuntimeException{

    public AuthenticationFailException(String message) {
        super(message);
    }

}
