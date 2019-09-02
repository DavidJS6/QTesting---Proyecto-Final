Feature: Simple maths
  In order to do maths
  As a developer
  I want to increment variables

  Scenario: easy maths
    Given a variable set to 1
    When I increment the variable by 1
    Then the variable should contain 2
      And the value is again 2

  Scenario Outline: much more complex stuff
    Given a variable set to <number>
    When I increment the variable by <delta>
    Then the variable should contain <result>

    Examples:
    | number | delta | result |
    | 10     | 20    | 30     |
    | 100    | 1000  | 1100   |
    | 220    | 50    | 270   |

