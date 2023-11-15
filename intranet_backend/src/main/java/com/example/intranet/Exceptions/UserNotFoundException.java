package com.example.intranet.Exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){super(message);}
}
