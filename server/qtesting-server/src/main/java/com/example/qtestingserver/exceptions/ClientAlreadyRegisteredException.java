package com.example.qtestingserver.exceptions;

public class ClientAlreadyRegisteredException extends Throwable {

    public ClientAlreadyRegisteredException(String errorMessage){
        super(errorMessage);
    }

}
