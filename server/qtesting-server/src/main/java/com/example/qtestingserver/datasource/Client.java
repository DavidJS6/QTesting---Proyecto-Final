package com.example.qtestingserver.datasource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class Client implements Serializable {

    @JsonIgnore
    private static Client clientInstance;

    private String nombre;
    private Double saldo;

    private Client(){
        this.saldo = 0D;
    }

    public static Client getInstance(){
        if(clientInstance == null){
            return new Client();
        }else{
            return clientInstance;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
