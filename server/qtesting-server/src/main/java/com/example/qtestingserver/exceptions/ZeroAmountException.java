package com.example.qtestingserver.exceptions;

public class ZeroAmountException extends Throwable {

    public ZeroAmountException() {
        //super("The amount needs to be higher than zero (0)");
        super("El monto debe ser mayor a cero (0)");
    }

}
