# new feature
# Tags: optional
@Android @Login
Feature: Login

  @Positive
  Scenario Outline: Login with registered phone number and correct password
    Given User is on Quotes App login page
    When User input "<phoneNumber>" on phone number input field on login page
    When User input "<password>" on password input field on login page
    When User click login button on login page
    Then User is on home page
    Examples:
      | phoneNumber | password |
      | 89695966513 | Test111! |
      | 85720105010 | Test333! |

