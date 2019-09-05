package com.example.qtestingserver.exceptions;

public class BalanceNotSufficientException extends Throwable {

    public BalanceNotSufficientException(String errorMessage){
        super(errorMessage);
    }

}
