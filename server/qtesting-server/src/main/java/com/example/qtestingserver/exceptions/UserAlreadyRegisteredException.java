package com.example.qtestingserver.exceptions;

public class UserAlreadyRegisteredException extends Throwable {

    public UserAlreadyRegisteredException(){
        //super("User is already registered");
        super("Ese usuario ya se encuentra registrado");
    }

}
