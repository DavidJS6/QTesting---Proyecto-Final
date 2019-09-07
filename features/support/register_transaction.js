const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const httpClient = require('request-promise')

let registerResponse = undefined;
let transactionResponse = undefined;

Given('Los siguientes datos NOMBRE {string} y MONTO {int}', function (name, amount) {
    this.newUser = {
        name: name
    };
    this.transactionData = {
        userName: name,
        transactionAmount: amount
    }
});

When('Preparo el JSON para registrar un nuevo usuario', function () {
    this.httpTransactionOptions = {
        method: 'POST',
        uri: 'http://localhost:4868/register-user',
        json: true,
        body: this.newUser,
        resolveWithFullResponse: true
    };
});

When('Hago una request POST para registrar al usuario', async function () {
    await httpClient(this.httpTransactionOptions)
    .then(function(response) {
        registerResponse = response;
    })
    .catch(function(error) {
        registerResponse = error;
    });
});

When('Preparo el JSON para registrar la transaccion', function () {
    this.httpTransactionOptions = {
        method: 'POST',
        uri: 'http://localhost:4868/register-income',
        json: true,
        body: this.transactionData,
        resolveWithFullResponse: true
    };
});

When('Hago una request POST para registrar la transaccion', async function () {
    await httpClient(this.httpTransactionOptions)
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