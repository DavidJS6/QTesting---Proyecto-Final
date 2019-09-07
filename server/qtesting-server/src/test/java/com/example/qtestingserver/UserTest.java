package com.example.qtestingserver;

import com.example.qtestingserver.classes.UserManager;
import com.example.qtestingserver.database.User;
import com.example.qtestingserver.exceptions.*;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test (expected = InvalidNameException.class)
    public void invalidClientNameTest() throws InvalidNameException, UserAlreadyRegisteredException {
        String name = "$D@vid S@ndoval$";
        UserManager userManager = new UserManager();
        userManager.registerClient(name);
    }

    @Test
    public void clientSuccessfullyRegisteredTest() throws InvalidNameException, UserAlreadyRegisteredException {
        String name = "David Sandoval Test Uno";
        UserManager userManager = new UserManager();
        userManager.registerClient(name);
    }

    @Test (expected = UserNotRegisteredException.class)
    public void transactionWithNoRegisteredClient() throws ZeroAmountException, UserNotRegisteredException {
        String name = "David Sandoval Test Dos";
        Double amount = 20.0;
        UserManager userManager = new UserManager();
        userManager.registerIncome(name, amount);
    }

    @Test (expected = ZeroAmountException.class)
    public void transactionWithAmountZeroTest() throws InvalidNameException, ZeroAmountException, UserNotRegisteredException, UserAlreadyRegisteredException {
        String name = "David Sandoval Test Tres";
        Double amount = 0.0;
        UserManager userManager = new UserManager();
        userManager.registerClient(name);
        userManager.registerIncome(name, amount);
    }

    @Test (expected = BalanceNotSufficientException.class)
    public void transactionWithInsufficientBalance() throws InvalidNameException, UserNotRegisteredException, BalanceNotSufficientException, ZeroAmountException, UserAlreadyRegisteredException {
        String name = "David Sandoval Test Cuatro";
        Double amount = 20.0;
        UserManager userManager = new UserManager();
        userManager.registerClient(name);
        userManager.registerWithdrawal(name, amount);
    }

    @Test
    public void incomeTransactionTest() throws InvalidNameException, ZeroAmountException, UserNotRegisteredException, UserAlreadyRegisteredException {
        String name = "Davide Sandoval Test Cinco";
        Double amount = 20.0;
        Double expectedBalance = 20.0;
        UserManager userManager = new UserManager();
        userManager.registerClient(name);
        User user = userManager.registerIncome(name, amount);
        Assert.assertEquals(user.getBalance(), expectedBalance);
    }

    @Test
    public void withdrawalTransactionTest() throws InvalidNameException, ZeroAmountException, UserNotRegisteredException, BalanceNotSufficientException, UserAlreadyRegisteredException {
        String name = "David Sandoval Test Seis";
        Double income = 20.0;
        Double withdrawal = 5.0;
        Double expectedBalance = 15.0;
        UserManager userManager = new UserManager();
        userManager.registerClient(name);
        userManager.registerIncome(name, income);
        User user = userManager.registerWithdrawal(name, withdrawal);
        Assert.assertEquals(user.getBalance(), expectedBalance);
    }

}
