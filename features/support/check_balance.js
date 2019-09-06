const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const httpClient = require('request-promise')

let clientData = {};
let httpOptions = {};
let serverResponse = undefined;

Given('El siguiente dato NOMBRE {string}', function (name) {
    clientData = {
        name: name
    }
});

When('Preparo el JSON con los datos del cliente', function () {
    httpOptions = {
        method: 'POST',
        uri: 'http://localhost:4860/get-client',
        json: true,
        body: clientData,
        resolveWithFullResponse: true
    };
});

Then('Hago una request POST para obtener el balance del cliente', async function () {
    await httpClient(httpOptions)
    .then(function(response) {
        serverResponse = response;
    })
    .catch(function(error) {
        serverResponse = error;
    });
});

Then('Recibo una respuesta con http status {int}', function (httpStatus) {
    expect(httpStatus).to.eql(serverResponse.statusCode);
});