package com.example.qtestingserver;

import com.example.qtestingserver.classes.ClientManager;
import com.example.qtestingserver.database.Client;
import com.example.qtestingserver.exceptions.*;
import org.junit.Assert;
import org.junit.Test;

public class ClientTest {

    public ClientTest(){}

    @Test (expected = InvalidNameException.class)
    public void invalidClientNameTest() throws InvalidNameException, ClientAlreadyRegisteredException {
        String name = "$D@vid S@ndoval$";
        ClientManager clientManager = new ClientManager();
        clientManager.registerClient(name);
    }

    @Test (expected = ClientAlreadyRegisteredException.class)
    public void clientAlreadyRegisteredTest() throws InvalidNameException, ClientAlreadyRegisteredException {
        String name = "David Sandoval";
        ClientManager clientManager = new ClientManager();
        clientManager.registerClient(name);
        clientManager.registerClient(name);
    }

    @Test
    public void clientSuccessfulRegistrationTest() throws InvalidNameException, ClientAlreadyRegisteredException {
        String name = "David Sandoval Test Uno";
        ClientManager clientManager = new ClientManager();
        clientManager.registerClient(name);
    }

    @Test (expected = ClientNotRegisteredException.class)
    public void transactionWithNoRegisteredClient() throws ZeroAmountException, ClientNotRegisteredException {
        String name = "David Sandoval Test Dos";
        Double amount = 20.0;
        ClientManager clientManager = new ClientManager();
        clientManager.registerIncome(name, amount);
    }

    @Test (expected = ZeroAmountException.class)
    public void transactionWithAmountZeroTest() throws InvalidNameException, ZeroAmountException, ClientNotRegisteredException, ClientAlreadyRegisteredException {
        String name = "David Sandoval Test Tres";
        Double amount = 0.0;
        ClientManager clientManager = new ClientManager();
        clientManager.registerClient(name);
        clientManager.registerIncome(name, amount);
    }

    @Test (expected = BalanceNotSufficientException.class)
    public void transactionWithInsufficientBalance() throws InvalidNameException, ClientNotRegisteredException, BalanceNotSufficientException, ZeroAmountException, ClientAlreadyRegisteredException {
        String name = "David Sandoval Test Cuatro";
        Double amount = 20.0;
        ClientManager clientManager = new ClientManager();
        clientManager.registerClient(name);
        clientManager.registerWithdrawal(name, amount);
    }

    @Test
    public void transactionToIncreaseBalance() throws InvalidNameException, ZeroAmountException, ClientNotRegisteredException, ClientAlreadyRegisteredException {
        String name = "Davide Sandoval Test Cinco";
        Double amount = 20.0;
        Double expectedBalance = 20.0;
        ClientManager clientManager = new ClientManager();
        clientManager.registerClient(name);
        Client client = clientManager.registerIncome(name, amount);
        Assert.assertEquals(client.getBalance(), expectedBalance);
    }

    @Test
    public void transactionToReduceBalance() throws InvalidNameException, ZeroAmountException, ClientNotRegisteredException, BalanceNotSufficientException, ClientAlreadyRegisteredException {
        String name = "David Sandoval Test Seis";
        Double income = 20.0;
        Double withdrawal = 5.0;
        Double expectedBalance = 15.0;
        ClientManager clientManager = new ClientManager();
        clientManager.registerClient(name);
        clientManager.registerIncome(name, income);
        Client client = clientManager.registerWithdrawal(name, withdrawal);
        Assert.assertEquals(client.getBalance(), expectedBalance);
    }

}
