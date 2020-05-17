# new feature
# Tags: optional
@Android @Transaction
Feature: Transaction

  @Positive @Wallet @Login @LogoutHook
  Scenario Outline: Buy data package for valid phone number through wallet payment with sufficient balance
    And User is on Quotes Landing page
    And User click login to account button on landing page
    And User is on login page
    And User input "81290137272" on phone number input field on login page
    And User input "Eduardus111!" on password input field on login page
    And User click login to account button on login page
    And User is on home page
    When User click data package on transaction column on home page
    When User is on data package page
    When User input "<chosenPhoneNumber>" as chosen phone number on phone number input field on data package page
    When User see data package list on data package page
    When User click data package that has "<chosenPrice>" on its price tag
    When User see transaction pop up window
    When User click choose method button on transaction pop up window
    When User click wallet balance method radio button on transaction pop up window
    When User input "<pin>" on pin input field on transaction pop up window
    When User click pay now button on transaction pop up window
    Then User transaction is success

    Examples:
      | chosenPhoneNumber | chosenPrice | pin    |
      | 81290137272       | Rp25.000    | 345678 |
      | 81290137272       | Rp80.000    | 345678 |
      | 81290137272       | Rp89.000    | 345678 |
