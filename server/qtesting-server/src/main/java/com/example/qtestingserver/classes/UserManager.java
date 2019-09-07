package com.example.qtestingserver.classes;

import com.example.qtestingserver.database.User;
import com.example.qtestingserver.exceptions.*;

public class UserManager {

    private UserService userService;

    private static final String REGULAR_EXPRESION_NAME = "^[a-zñA-ZÑ]+(([',. -][a-zñA-ZÑ ])?[a-zñA-ZÑ]*)*$";

    public UserManager() {
        userService = new UserService();
    }

    // Se debera evitar la insercion de caracteres especiales
    public User registerClient(String name) throws InvalidNameException, UserAlreadyRegisteredException {
        checkClientName(name);
        //checkIfClientIsRegistered(name);
        return userService.registerClient(name);
    }

    public User getClient(String name) throws UserNotRegisteredException {
        checkIfClientExist(name);
        return userService.getClient(name);
    }

    // Se debera validar que el usuario exista en la lista
    public User registerIncome(String name, Double amount) throws ZeroAmountException, UserNotRegisteredException {
        checkZeroAmount(amount);
        checkIfClientExist(name);
        return userService.registerIncome(name, amount);
    }

    // Se debera validar que el usuario exista en la lista
    // Se debera validar que el usuario tenga sueldo suficiente para el retiro
    public User registerWithdrawal(String name, Double amount) throws ZeroAmountException, UserNotRegisteredException, BalanceNotSufficientException {
        checkZeroAmount(amount);
        checkIfClientExist(name);
        checkBalance(name, amount);
        return userService.registerWithdrawal(name, amount);
    }

    private void checkClientName(String name) throws InvalidNameException {
        if (!name.matches(REGULAR_EXPRESION_NAME)) {
            throw new InvalidNameException();
        }
    }

    private void checkIfClientIsRegistered(String name) throws UserAlreadyRegisteredException {
        if(userService.getClient(name) != null){
            throw new UserAlreadyRegisteredException();
        }
    }

    private void checkIfClientExist(String name) throws UserNotRegisteredException {
        if (userService.getClient(name) == null) {
            throw new UserNotRegisteredException();
        }
    }

    private void checkZeroAmount(Double amount) throws ZeroAmountException {
        if (amount <= 0) {
            throw new ZeroAmountException();
        }
    }

    private void checkBalance(String name, Double amount) throws BalanceNotSufficientException {
        if (userService.getClient(name).getBalance() < amount) {
            throw new BalanceNotSufficientException();
        }
    }

}
