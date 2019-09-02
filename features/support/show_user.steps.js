const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const { Builder, By, Key, until } = require('selenium-webdriver');

let userName = "";
let userCi = 0;
let chromeDriver = undefined;

Given('Dados datos de usuario nombre: {string} y ci: {int}', function (string, int) {
  userName = string;
  userCi = int;
});

When('Navego a la pagina principal', async function () {
  chromeDriver = await new Builder().forBrowser('chrome').build();
  await chromeDriver.get('http://localhost:8080/ui');
});

When('Llenar el campo de nombre', async function () {
  await chromeDriver.findElement(By.name('nameInput')).sendKeys(userName);
});

When('Llenar el campo de ci', async function () {
  await chromeDriver.findElement(By.name('ciInput')).sendKeys(userCi);
});

When('Hacer click en el boton Show', async function () {
  await chromeDriver.findElement(By.name('showButton')).click();
});

Then('Se debe mostrar la cadena {string}', async function (expected) {
  await chromeDriver.findElement(By.name('showArea'))
    .getText().then(function (text) {
      showText = text;
    });

  expect(showText).to.eql(expected);
  await chromeDriver.quit();
});
