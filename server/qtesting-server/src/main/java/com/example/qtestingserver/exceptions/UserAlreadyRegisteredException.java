package com.example.qtestingserver.exceptions;

public class UserAlreadyRegisteredException extends Throwable {

    public UserAlreadyRegisteredException(String errorMessage){
        super(errorMessage);
    }

}
