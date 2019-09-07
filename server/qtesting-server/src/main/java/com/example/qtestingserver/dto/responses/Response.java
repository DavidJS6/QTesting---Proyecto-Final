package com.example.qtestingserver.dto.responses;

import com.example.qtestingserver.database.User;

public class Response {

    private boolean transactionCompleted;
    private String message;
    private User user;

    public Response(boolean transactionCompleted, String message, User user){
        this.transactionCompleted = transactionCompleted;
        this.message = message;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
