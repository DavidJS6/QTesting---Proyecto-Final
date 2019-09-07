package com.example.qtestingserver.exceptions;

public class BalanceNotSufficientException extends Throwable {

    public BalanceNotSufficientException(){
        //super("Insufficient balance to complete the transaction")
        super("Saldo insuficiente para completar la transacción");
    }

}
