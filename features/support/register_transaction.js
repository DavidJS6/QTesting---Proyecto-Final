const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const httpClient = require('request-promise')

let newClient = {};
let transactionData = {}
let httpOptions = {};
let registerResponse = undefined;
let transactionResponse = undefined;

Given('Los siguientes datos NOMBRE {string} y MONTO {int}', function (name, amount) {
    newClient = {
        name: name
    };
    transactionData = {
        clientName: name,
        transactionAmount: amount
    }
});

When('Preparo el JSON para registrar un nuevo cliente', function () {
    httpOptions = {
        method: 'POST',
        uri: 'http://localhost:4860/register-client',
        json: true,
        body: newClient,
        resolveWithFullResponse: true
    };
});

When('Hago una request POST para registrar al cliente', async function () {
    await httpClient(httpOptions)
    .then(function(response) {
        registerResponse = response;
    })
    .catch(function(error) {
        registerResponse = error;
    });
});

When('Preparo el JSON para registrar la transaccion', function () {
    httpOptions = {
        method: 'POST',
        uri: 'http://localhost:4860/register-income',
        json: true,
        body: transactionData,
        resolveWithFullResponse: true
    };
});

When('Hago una request POST para registrar la transaccion', async function () {
    await httpClient(httpOptions)
    .then(function(response) {
        transactionResponse = response;
    })
    .catch(function(error) {
        transactionResponse = error;
    });
});

Then('Recibo una respuesta con http status {int} de la transaccion', function (httpStatus) {
    expect(httpStatus).to.eql(transactionResponse.statusCode);
});