package com.example.qtestingserver.database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {

    private String name;
    private Double balance;
    private List<Transaction> balanceDetail;

    public Client(String name){
        this.name = name;
        this.balance = 0D;
        balanceDetail = new ArrayList<>();
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

    public List<Transaction> getBalanceDetail() {
        return balanceDetail;
    }

    public void setBalanceDetail(List<Transaction> balanceDetail) {
        this.balanceDetail = balanceDetail;
    }
}
