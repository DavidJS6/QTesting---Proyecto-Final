package com.example.qtestingserver.exceptions;

public class ZeroAmountException extends Throwable {

    public ZeroAmountException(String errorMessage){
        super(errorMessage);
    }

}
