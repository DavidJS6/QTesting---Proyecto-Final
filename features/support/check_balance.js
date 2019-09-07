const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const httpClient = require('request-promise')

let serverResponse = undefined;

Given('El siguiente dato NOMBRE {string}', function (name) {
    this.userData = {
        name: name
    }
});

When('Preparo el JSON con los datos del usuario', function () {
    this.httpOptions = {
        method: 'POST',
        uri: 'http://localhost:42624/get-user',
        json: true,
        body: this.userData,
        resolveWithFullResponse: true
    };
});

Then('Hago una request POST para obtener el balance del usuario', async function () {
    await httpClient(this.httpOptions)
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