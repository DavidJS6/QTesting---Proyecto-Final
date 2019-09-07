const { setWorldConstructor } = require("cucumber");

class CustomWorld {
  constructor() {
    this.userData = {};
    this.expectedAmount;
    this.httpOptions = {};
    this.serverResponse = undefined;

    this.newUser = {};
    this.transactionData = {};
    this.httpTransactionOptions = {};

    this.userName;
    this.transactionAmount;
  }

}

setWorldConstructor(CustomWorld);