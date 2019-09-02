const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const httpClient = require('request-promise')

let newUser = {};
let httpOptions = {};
let urbanagerResponse = undefined;

Given('Los siguientes datos ID {int} NOMBRE {string} CI {int}', function (id, name, ci) {
  newUser = {
    id: id,
    name: name,
    ci: ci
  };
});

When('Preparo el JSON de los datos', function () {
  console.log('DONE');
  httpOptions = {
    method: 'POST',
    uri: 'http://localhost:8080/api/user',
    json: true,
    body: newUser,
    resolveWithFullResponse: true
  };
});

Then('Hago un request POST hacia el url user con los datos', async function () {
  await httpClient(httpOptions)
    .then(function(response) {
      urbanagerResponse = response;
    })
    .catch(function(error) {
      urbanagerResponse = error;
    });
});

Then('Recibo una respuesta con http status {int}', function (httpStatus) {
  expect(urbanagerResponse.statusCode).to.eql(httpStatus);
});
