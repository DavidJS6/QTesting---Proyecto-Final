package com.example.qtestingserver.exceptions;

public class UserNotRegisteredException extends Throwable {

    public UserNotRegisteredException(String errorMessage){
        super(errorMessage);
    }

}
