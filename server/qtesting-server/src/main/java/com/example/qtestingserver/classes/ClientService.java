package com.example.qtestingserver.classes;

import com.example.qtestingserver.database.Client;
import com.example.qtestingserver.database.DataSource;

public class ClientService {

    // Aqui se maneja el acceso a la clase Client (Base de datos)

    private DataSource dataSource;

    public ClientService(){
        dataSource = DataSource.getInstance();
    }

    public Client registerClient(String name){
        return dataSource.registerClient(name);
    }

    public Client getClient(String name){
        return dataSource.getClient(name);
    }

    public Client registerIncome(String name, Double amount){
        return dataSource.registerIncome(name, amount);
    }

    public Client registerWithdrawal(String name, Double amount){
        return dataSource.registerWithdrawal(name, amount);
    }

    public Double getTotalBlance(String name){
        return dataSource.getTotalBalance(name);
    }

}
