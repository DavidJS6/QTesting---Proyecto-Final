package com.example.qtestingserver.classes;

import com.example.qtestingserver.database.User;
import com.example.qtestingserver.exceptions.*;

public class UserManager {

    // Este sera el medio por el cual el controlador podra hacer cambios en la base de datos
    // Desde aqui se hara uso de la clase ClienteService para poder modificar los datos de
    // los clientes
    // De igual manera aqui se haran las validaciones respectivas de los servicios

    private UserService userService;

    // https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
    private String REGULAR_EXPRESION_NAME = "^[a-zñA-ZÑ]+(([',. -][a-zñA-ZÑ ])?[a-zñA-ZÑ]*)*$";
    //private String REGULAR_EXPRESION_NAME = "^[A-Za-z]+([\ A-Za-z]+)*";

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
            throw new InvalidNameException("Invalid name, you cannot use special characters!");
        }
    }

    private void checkIfClientIsRegistered(String name) throws UserAlreadyRegisteredException {
        if(userService.getClient(name) != null){
            throw new UserAlreadyRegisteredException("User is already registered");
        }
    }

    private void checkIfClientExist(String name) throws UserNotRegisteredException {
        if (userService.getClient(name) == null) {
            throw new UserNotRegisteredException("User not registered");
        }
    }

    private void checkZeroAmount(Double amount) throws ZeroAmountException {
        if (amount == 0) {
            throw new ZeroAmountException("The amount needs to be higher than zero");
        }
    }

    private void checkBalance(String name, Double amount) throws BalanceNotSufficientException {
        if (userService.getClient(name).getBalance() < amount) {
            throw new BalanceNotSufficientException("Insufficient balance to complete the transaction");
        }
    }

}
