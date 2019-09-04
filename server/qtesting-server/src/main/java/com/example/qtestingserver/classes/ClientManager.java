package com.example.qtestingserver.classes;

import com.example.qtestingserver.database.Client;

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
    public Client registerClient(String name) throws Exception {
        if (name.matches(REGULAR_EXPRESION_NAME)) {
            return clientService.registerClient(name);
        } else {
            throw new Exception("invalid name, you cannot use special characters!");
        }

    }

    // Se debera validar que el usuario exista en la lista
    public Client registerIncome(String name, Double amount) throws Exception {
        checkZeroAmount(amount);
        checkIfClientExist(name);
        return clientService.registerIncome(name, amount);
    }

    // Se debera validar que el usuario exista en la lista
    // Se debera validar que el usuario tenga sueldo suficiente para el retiro
    public Client registerWithdrawal(String name, Double amount) throws Exception {
        checkZeroAmount(amount);
        checkIfClientExist(name);
        checkBalance(name, amount);
        return clientService.registerWithdrawal(name, amount);
    }

    private void checkIfClientExist(String name) throws Exception {
        if (clientService.getClient(name) == null) {
            throw new Exception("Client not registered");
        }
    }

    private void checkZeroAmount(Double amount) throws Exception {
        if (amount == 0) {
            throw new Exception("The amount needs to be higher than zero");
        }
    }

    private void checkBalance(String name, Double amount) throws Exception {
        if (clientService.getClient(name).getBalance() < amount) {
            throw new Exception("Insufficient balance to complete the transaction");
        }
    }

}
