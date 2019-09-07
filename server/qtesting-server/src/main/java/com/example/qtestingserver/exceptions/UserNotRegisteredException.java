package com.example.qtestingserver.exceptions;

public class UserNotRegisteredException extends Throwable {

    public UserNotRegisteredException(){
        //super("User not registered");
        super("Ese usuario no se encuentra registrado");
    }

}
