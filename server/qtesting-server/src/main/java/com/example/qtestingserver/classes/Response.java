package com.example.qtestingserver.classes;

import com.example.qtestingserver.database.Client;

public class Response {

    private boolean transaction;
    private String message;
    private Client client;

    public Response(boolean transaction, String message, Client client){
        this.transaction = transaction;
        this.message = message;
        this.client = client;
    }

    public boolean isTransaction() {
        return transaction;
    }

    public void setTransaction(boolean transaction) {
        this.transaction = transaction;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
