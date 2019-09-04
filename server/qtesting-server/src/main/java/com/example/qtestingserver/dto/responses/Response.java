package com.example.qtestingserver.dto.responses;

import com.example.qtestingserver.database.Client;

public class Response {

    private boolean transactionCompleted;
    private String message;
    private Client client;

    public Response(boolean transactionCompleted, String message, Client client){
        this.transactionCompleted = transactionCompleted;
        this.message = message;
        this.client = client;
    }

    public boolean isTransactionCompleted() {
        return transactionCompleted;
    }

    public void setTransactionCompleted(boolean transactionCompleted) {
        this.transactionCompleted = transactionCompleted;
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
