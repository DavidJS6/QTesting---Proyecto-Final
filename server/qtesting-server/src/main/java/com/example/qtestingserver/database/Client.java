package com.example.qtestingserver.database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Client implements Serializable {

    private String name;
    private Double balance;

    public Client(String name){
        this.name = name;
        this.balance = 0D;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
