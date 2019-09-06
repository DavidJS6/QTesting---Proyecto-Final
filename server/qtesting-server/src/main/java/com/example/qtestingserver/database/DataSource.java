package com.example.qtestingserver.database;

import com.example.qtestingserver.constants.TransactionType;
import sun.util.cldr.CLDRLocaleDataMetaInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataSource {

    private static DataSource instance;

    private List<Client> listaClientes;

    private DataSource() {
        this.listaClientes = new ArrayList<>();
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Client registerClient(String name) {
        Client client = new Client(name);
        listaClientes.add(client);
        return client;
    }

    public Client registerIncome(String name, Double income) {
        Client client = getClient(name);
        client.setBalance(client.getBalance() + income);

        Transaction transaction = new Transaction(TransactionType.INCOME_TRANSACTION, new Date(), income);
        client.getBalanceDetail().add(transaction);
        return client;
    }

    public Client registerWithdrawal(String name, Double withdrawal) {
        Client client = getClient(name);
        client.setBalance(client.getBalance() - withdrawal);

        Transaction transaction = new Transaction(TransactionType.WITHDRAWAL_TRANSACTION, new Date(), withdrawal);
        client.getBalanceDetail().add(transaction);
        return client;
    }

    public Client getClient(String name) {
        for (Client client : listaClientes) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

}
