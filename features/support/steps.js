const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')


Given('a variable set to {int}', function (number) {
  this.setTo(number);
});

When('I increment the variable by {int}', function (delta) {
  this.incrementBy(delta);
});

Then('the variable should contain {int}', function (expected) {
  expect(this.result).to.eql(expected);
});

Then('the value is again {int}', function (number) {
  expect(this.result).to.eql(number);
});
