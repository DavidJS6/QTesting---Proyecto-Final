const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const { Builder, By, Key, until } = require('selenium-webdriver');

Given('Los siguientes datos de usuario NOMBRE {string} y MONTO {int}', function (name, amount) {
    this.userName = name;
    this.transactionAmount = amount;
});

When('Navego a la pagina principal del sistema', { timeout: 10 * 1000 } , async function () {
    chromeDriver = await new Builder().forBrowser('chrome').build();
    await chromeDriver.get('http://localhost:4868/home');
});

When('Introduzco el nombre del usuario', async function () {
    await chromeDriver.findElement(By.id('name-txt')).sendKeys(this.userName);
});

When('Presiono el boton Registrarse', async function () {
    await chromeDriver.findElement(By.id('register-button')).click();
});

When('Introduzco el monto para la transaccion', async function () {
    await chromeDriver.findElement(By.id('amount-txt')).sendKeys(this.transactionAmount);
});

When('Presiono el boton Registrar ingreso', async function () {
    await chromeDriver.findElement(By.id('income-button')).click();
});

Then('Se debe mostrar el balance de {string}', async function (expected) {
    await chromeDriver.findElement(By.id('balance-amount')).getText().then(function (text) {
        showText = text;
    });

    expect(showText).to.eql(expected);
    await chromeDriver.quit();
});