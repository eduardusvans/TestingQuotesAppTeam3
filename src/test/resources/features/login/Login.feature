# new feature
# Tags: optional
@Android @Login
Feature: Login

  @Positive @LogoutHookL
  Scenario Outline: Login with registered phone number and correct password
    Given User is on Quotes Landing page
    When User click login to account button on landing page
    And User is on login page
    And User input "<phoneNumber>" on phone number input field on login page
    And User input "<password>" on password input field on login page
    And User click login to account button on login page
    Then User is on home page
    Examples:
      | phoneNumber | password        |
      | 87722041553 | Bilalelbari111! |

  @Negative @Single @LogoutHookL
  Scenario Outline: Login with unregistered phone number, or invalid one of the input
    Given User is on Quotes Landing page
    When User click login to account button on landing page
    And User is on login page
    And User input "<phoneNumber>" on phone number input field on login page
    And User input "<password>" on password input field on login page
    And User click login to account button on login page
    Then User is still on login page
    Examples:
      | phoneNumber | password        |
      # unregistered phone number
      | 89695966514 | Abcdef1!        |
      # wrong password
      | 87722041553 | Bilalelbari123! |

  @Negative @All @LogoutHookL
  Scenario Outline: Login with unregistered phone number and invalid password input
    Given User is on Quotes Landing page
    When User click login to account button on landing page
    And User is on login page
    And User input "<phoneNumber>" on phone number input field on login page
    And User input "<password>" on password input field on login page
    And User click login to account button on login page
    Then User is still on login page
    Examples:
      | phoneNumber | password        |
      # all wrong phone number
      | 89695966514 | Bilalelbari123! |


