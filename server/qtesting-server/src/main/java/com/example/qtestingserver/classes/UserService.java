package com.example.qtestingserver.classes;

import com.example.qtestingserver.database.User;
import com.example.qtestingserver.database.DataSource;

public class UserService {

    // Aqui se maneja el acceso a la clase User (Base de datos)

    private DataSource dataSource;

    public UserService(){
        dataSource = DataSource.getInstance();
    }

    public User registerClient(String name){
        return dataSource.registerUser(name);
    }

    public User getClient(String name){
        return dataSource.getUser(name);
    }

    public User registerIncome(String name, Double amount){
        return dataSource.registerIncome(name, amount);
    }

    public User registerWithdrawal(String name, Double amount){
        return dataSource.registerWithdrawal(name, amount);
    }

}
