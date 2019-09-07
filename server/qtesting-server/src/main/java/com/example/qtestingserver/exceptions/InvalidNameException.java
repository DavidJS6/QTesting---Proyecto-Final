package com.example.qtestingserver.exceptions;

public class InvalidNameException extends Throwable {

    public InvalidNameException(){
        //super("Invalid name, you cannot use numbers special characters!");
        super("Nombre inválido, no puede utilizar números o caracteres especiales");
    }

}
