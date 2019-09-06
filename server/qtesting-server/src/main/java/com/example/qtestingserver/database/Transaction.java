package com.example.qtestingserver.database;

import java.util.Date;

public class Transaction {

    private String transactionType;
    private Date transactionDate;
    private Double amount;

    public Transaction(String transactionType, Date transactionDate, Double amount) {
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
