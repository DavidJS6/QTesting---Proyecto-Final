package com.example.qtestingserver.controllers;

import com.example.qtestingserver.datasource.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @RequestMapping(
            value = "/register-client",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> registerClient(String name){
        Client client = Client.getInstance();

        // Hacer validaciones para evitar

        client.setNombre(name);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/register-income",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> registerIncome(Integer number) {
        Client client = Client.getInstance();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/register-withdrawal",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> registerWithdrawal(){
        Client client = Client.getInstance();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}
