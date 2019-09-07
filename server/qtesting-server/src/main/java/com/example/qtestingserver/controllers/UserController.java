package com.example.qtestingserver.controllers;

import com.example.qtestingserver.classes.UserManager;
import com.example.qtestingserver.database.User;
import com.example.qtestingserver.dto.requests.UserRegistrationRequest;
import com.example.qtestingserver.dto.requests.TransactionRequest;
import com.example.qtestingserver.dto.responses.Response;
import com.example.qtestingserver.constants.Messages;
import com.example.qtestingserver.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserManager userManager;

    public UserController(){
        userManager = new UserManager();
    }

    @RequestMapping(
            value = "/register-user",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> registerClient(@RequestBody UserRegistrationRequest request){
        try {
            User user = userManager.registerClient(request.getName());
            return new ResponseEntity<>(new Response(true, Messages.SUCCESSFULLY_REGISTERED, user), HttpStatus.OK);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (InvalidNameException | UserAlreadyRegisteredException ex) {
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = "/login-user",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> loginClient(@RequestBody UserRegistrationRequest request){
        try {
            User user = userManager.getClient(request.getName());
            return new ResponseEntity<>(new Response(true, Messages.SUCCESSFULLY_VERIFIED, user), HttpStatus.OK);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UserNotRegisteredException ex) {
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = "/get-user",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> getBalance(@RequestBody UserRegistrationRequest request){
        try {
            User user = userManager.getClient(request.getName());
            return new ResponseEntity<>(new Response(true, Messages.SUCCESSFULLY_TRANSACTION, user), HttpStatus.OK);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UserNotRegisteredException ex) {
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
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
            User user = userManager.registerIncome(request.getUserName(), request.getTransactionAmount());
            return new ResponseEntity<>(new Response(true, Messages.SUCCESSFULLY_TRANSACTION, user), HttpStatus.OK);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UserNotRegisteredException | ZeroAmountException ex) {
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
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
            User user = userManager.registerWithdrawal(request.getUserName(), request.getTransactionAmount());
            return new ResponseEntity<>(new Response(true, Messages.SUCCESSFULLY_TRANSACTION, user), HttpStatus.OK);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UserNotRegisteredException | ZeroAmountException | BalanceNotSufficientException ex) {
            return new ResponseEntity<>(new Response(false, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

}
