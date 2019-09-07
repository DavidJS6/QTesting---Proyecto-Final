package com.example.qtestingserver.database;

import com.example.qtestingserver.constants.TransactionType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataSource {

    private static DataSource instance;

    private List<User> listaUsuarios;

    private DataSource() {
        this.listaUsuarios = new ArrayList<>();
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public User registerUser(String name) {
        User user = getUser(name);
        if(user == null){
            user = new User(name);
            listaUsuarios.add(user);
        }else{
            user.setBalance(0D);
            user.setBalanceDetail(new ArrayList<>());
        }
        return user;
    }

    public User getUser(String name) {
        for (User user : listaUsuarios) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public User registerIncome(String name, Double income) {
        User user = getUser(name);
        user.setBalance(user.getBalance() + income);

        Transaction transaction = new Transaction(TransactionType.INCOME_TRANSACTION, new Date(), income);
        user.getBalanceDetail().add(transaction);
        return user;
    }

    public User registerWithdrawal(String name, Double withdrawal) {
        User user = getUser(name);
        user.setBalance(user.getBalance() - withdrawal);

        Transaction transaction = new Transaction(TransactionType.WITHDRAWAL_TRANSACTION, new Date(), withdrawal);
        user.getBalanceDetail().add(transaction);
        return user;
    }

}
