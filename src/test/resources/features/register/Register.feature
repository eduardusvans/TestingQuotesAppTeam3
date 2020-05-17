# new feature
# Tags: optional
@Android @Register
Feature: Register

  @Positive @OTP @LogoutHook @DeleteHook
  Scenario Outline: Register through OTP verification with valid inputs
    Given User is on Quotes Landing page
    When User click create account button on landing page
    When User is on register page
    When User input "<phoneNumber>" on phone number input field on register page
    When User input "<fullName>" on full name input field on register page
    When User input "<email>" on email input field on register page
    When User input "<password>" on password input field on register page
    When User input "<confirmPassword>" on confirm password input field on register page
    When User input "<pin>" on pin input field on register page
    When User click create account button on register page
    When User see the verification method window on register page
    When User click phone number button on verification method window
    When User is on OTP page
    When User get a valid OTP number
    When User enter valid OTP number on OTP page
    When User click continue button on OTP page
    When User is on success page
    When User click start using button on success page
    Then User is on login page
    Then User is registered as Quotes user
    Examples:
      | phoneNumber | fullName             | email                      | password         | confirmPassword  | pin    |
      | 89695966514 | abc                  | testingregister3@gmail.com | Abcdef1!         | Abcdef1!         | 123456 |
      | 89695966514 | abcdefghijklmnopqrst | testingregister3@gmail.com | Abcdefghijklmn1! | Abcdefghijklmn1! | 123456 |

  @Positive @Email @LogoutHook @DeleteHook
  Scenario Outline: Register through email verification with valid inputs
    Given User is on Quotes Landing page
    When User click create account button on landing page
    When User is on register page
    When User input "<phoneNumber>" on phone number input field on register page
    When User input "<fullName>" on full name input field on register page
    When User input "<email>" on email input field on register page
    When User input "<password>" on password input field on register page
    When User input "<confirmPassword>" on confirm password input field on register page
    When User input "<pin>" on pin input field on register page
    When User click create account button on register page
    When User see the verification method window on register page
    When User click email button on verification method window
    When User get an email verification
    When User click an email verification
    When User click go to login page button on verification method window
    Then User is on login page
    Then User is registered as Quotes user
    Examples:
      | phoneNumber | fullName             | email                      | password         | confirmPassword  | pin    |
      | 89695966514 | abc                  | testingregister3@gmail.com | Abcdef1!         | Abcdef1!         | 123456 |
      | 89695966514 | abcdefghijklmnopqrst | testingregister3@gmail.com | Abcdefghijklmn1! | Abcdefghijklmn1! | 123456 |

  @Negative
  Scenario Outline: Register an account with one of the input is invalid
    Given User is on Quotes Landing page
    When User click create account button on landing page
    When User is on register page
    When User input "<phoneNumber>" on phone number input field on register page
    When User input "<fullName>" on full name input field on register page
    When User input "<email>" on email input field on register page
    When User input "<password>" on password input field on register page
    When User input "<confirmPassword>" on confirm password input field on register page
    When User input "<pin>" on pin input field on register page
    When User click create account button on register page
    Then User doesn't see the verification method window on register page
    Then User is still on register page

    Examples:
      | phoneNumber | fullName | email                      | password | confirmPassword  | pin    |
      # full name less than 3 characters
      | 89695966514 | ab       | testingregister3@gmail.com | Abcdef1! | Abcdef1!         | 123456 |
      # wrong email format
      | 89695966514 | abc      | testingregister3           | Abcdef1! | Abcdef1!         | 123456 |
      # taken email
      | 89695966514 | abc      | testinglogin3@gmail.com    | Abcdef1! | Abcdef1!         | 123456 |
      # taken phone number
      | 87722041553 | abc      | testingregister3@gmail.com | Abcdef1! | Abcdef1!         | 123456 |
      # password less than 8 characters
      | 87722041553 | abc      | testingregister3@gmail.com | Abcde1!  | Abcde1!          | 123456 |
      # Different confirm password input with password input
      | 87722041553 | abc      | testingregister3@gmail.com | Abcdef1! | Abcdefghijklmn1! | 123456 |
      # Pin number is not 6 characters
      | 89695966514 | abc      | testingregister3@gmail.com | Abcdef1! | Abcdef1!         | 12345  |


