package com.kat.recruitapp.exceptions;

public class AuthenticationFailException extends RuntimeException{

    public AuthenticationFailException(String message) {
        super(message);
    }

    public AuthenticationFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
