package com.example.qtestingserver.controllers;

import com.example.qtestingserver.classes.ClientManager;
import com.example.qtestingserver.dto.requests.ClientRegistrationRequest;
import com.example.qtestingserver.dto.requests.TransactionRequest;
import com.example.qtestingserver.dto.responses.Response;
import com.example.qtestingserver.constants.Messages;
import com.example.qtestingserver.database.Client;
import com.example.qtestingserver.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public ResponseEntity<Object> registerClient(@RequestBody ClientRegistrationRequest request){
        try {
            Client client = clientManager.registerClient(request.getName());
            return new ResponseEntity<>(new Response(true, Messages.SUCCESSFULLY_REGISTERED, client), HttpStatus.OK);
        } catch (InvalidNameException | ClientAlreadyRegisteredException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/login-client",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> loginClient(@RequestBody ClientRegistrationRequest request){
        try {
            Client client = clientManager.getClient(request.getName());
            return new ResponseEntity<>(new Response(true, Messages.SUCCESSFULLY_VERIFIED, client), HttpStatus.OK);
        } catch (ClientNotRegisteredException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/register-income",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> registerIncome(@RequestBody TransactionRequest request) {
        try {
            Client client = clientManager.registerIncome(request.getClientName(), request.getTransactionAmount());
            return new ResponseEntity<>(new Response(true, Messages.SUCCESSFULLY_TRANSACTION, client), HttpStatus.OK);
        } catch (ClientNotRegisteredException | ZeroAmountException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/register-withdrawal",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> registerWithdrawal(@RequestBody TransactionRequest request){
        try {
            Client client = clientManager.registerWithdrawal(request.getClientName(), request.getTransactionAmount());
            return new ResponseEntity<>(new Response(true, Messages.SUCCESSFULLY_TRANSACTION, client), HttpStatus.OK);
        } catch (ClientNotRegisteredException | ZeroAmountException | BalanceNotSufficientException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
