package com.example.qtestingserver.classes;

import com.example.qtestingserver.database.Client;
import com.example.qtestingserver.exceptions.*;

public class ClientManager {

    // Este sera el medio por el cual el controlador podra hacer cambios en la base de datos
    // Desde aqui se hara uso de la clase ClienteService para poder modificar los datos de
    // los clientes
    // De igual manera aqui se haran las validaciones respectivas de los servicios

    private ClientService clientService;

    // https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
    private String REGULAR_EXPRESION_NAME = "^[a-zñA-ZÑ]+(([',. -][a-zñA-ZÑ ])?[a-zñA-ZÑ]*)*$";
    //private String REGULAR_EXPRESION_NAME = "^[A-Za-z]+([\ A-Za-z]+)*";

    public ClientManager() {
        clientService = new ClientService();
    }

    // Se debera evitar la insercion de caracteres especiales
    public Client registerClient(String name) throws InvalidNameException, ClientAlreadyRegisteredException {
        checkClientName(name);
        checkIfClientIsRegistered(name);
        return clientService.registerClient(name);
    }

    public Client getClient(String name) throws ClientNotRegisteredException {
        checkIfClientExist(name);
        return clientService.getClient(name);
    }

    // Se debera validar que el usuario exista en la lista
    public Client registerIncome(String name, Double amount) throws ZeroAmountException, ClientNotRegisteredException {
        checkZeroAmount(amount);
        checkIfClientExist(name);
        return clientService.registerIncome(name, amount);
    }

    // Se debera validar que el usuario exista en la lista
    // Se debera validar que el usuario tenga sueldo suficiente para el retiro
    public Client registerWithdrawal(String name, Double amount) throws ZeroAmountException, ClientNotRegisteredException, BalanceNotSufficientException {
        checkZeroAmount(amount);
        checkIfClientExist(name);
        checkBalance(name, amount);
        return clientService.registerWithdrawal(name, amount);
    }

    public Double getTotalBalance(String name) throws ClientNotRegisteredException {
        checkIfClientExist(name);
        return clientService.getTotalBlance(name);
    }

    private void checkClientName(String name) throws InvalidNameException {
        if (!name.matches(REGULAR_EXPRESION_NAME)) {
            throw new InvalidNameException("Invalid name, you cannot use special characters!");
        }
    }

    private void checkIfClientIsRegistered(String name) throws ClientAlreadyRegisteredException {
        if(clientService.getClient(name) != null){
            throw new ClientAlreadyRegisteredException("Client is already registered");
        }
    }

    private void checkIfClientExist(String name) throws ClientNotRegisteredException {
        if (clientService.getClient(name) == null) {
            throw new ClientNotRegisteredException("Client not registered");
        }
    }

    private void checkZeroAmount(Double amount) throws ZeroAmountException {
        if (amount == 0) {
            throw new ZeroAmountException("The amount needs to be higher than zero");
        }
    }

    private void checkBalance(String name, Double amount) throws BalanceNotSufficientException {
        if (clientService.getClient(name).getBalance() < amount) {
            throw new BalanceNotSufficientException("Insufficient balance to complete the transaction");
        }
    }

}
