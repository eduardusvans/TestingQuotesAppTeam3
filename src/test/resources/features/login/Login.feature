# new feature
# Tags: optional
@Android @Login
Feature: Login

  @Positive @NeedLogout
  Scenario Outline: Login with registered phone number and correct password
    Given User is on Quotes Landing page
    When User click login to account button on starting page
    When User is on Quotes login page
    When User input "<phoneNumber>" on phone number input field on login page
    When User input "<password>" on password input field on login page
    When User click login button on login page
    Then User is on home page
    Examples:
      | phoneNumber | password     |
      | 85926182305 | Eduardus333! |



