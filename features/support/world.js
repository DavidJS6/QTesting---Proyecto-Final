const { setWorldConstructor } = require("cucumber");

class CustomWorld {
  constructor() {
    this.result = 0;
  }

  setTo(number) {
    this.result = number;
  }

  incrementBy(number) {
    this.result += number;
  }
}

setWorldConstructor(CustomWorld);