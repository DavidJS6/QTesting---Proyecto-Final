package com.example.qtestingserver.controllers;

import com.example.qtestingserver.classes.ClientManager;
import com.example.qtestingserver.classes.Response;
import com.example.qtestingserver.database.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private ClientManager clientManager;

    public ClientController(){
        clientManager = new ClientManager();
    }

    @RequestMapping(
            value = "/register-client",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> registerClient(String name){
        try {
            Client client = clientManager.registerClient(name);
            return new ResponseEntity<>(new Response(true, "Client successfully registered", client), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/register-income",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> registerIncome(String name, Double amount) {
        try {
            Client client = clientManager.registerIncome(name, amount);
            return new ResponseEntity<>(new Response(true, "transaction successfully registered", client), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/register-withdrawal",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> registerWithdrawal(String name, Double amount){
        try {
            Client client = clientManager.registerWithdrawal(name, amount);
            return new ResponseEntity<>(new Response(true, "transaction successfully registered", client), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
