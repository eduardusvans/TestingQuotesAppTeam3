package demo.steps_definitions;

import demo.controller.UserController;
import demo.pages.LandingPage;
import demo.pages.OtpPage;
import demo.pages.RegisterPage;
import demo.pages.SuccessPage;
import demo.request.LoginRequest;
import demo.request.LogoutRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static demo.steps_definitions.LoginStepDefinitions.getUserPassword;
import static demo.steps_definitions.LoginStepDefinitions.getUserPhoneNumber;

public class RegisterStepDefinitions {

    LandingPage landingPage = new LandingPage();
    RegisterPage registerPage = new RegisterPage();
    OtpPage otpPage = new OtpPage();
    SuccessPage successPage = new SuccessPage();

    String userEmail;
    String userOtpNumber;
    String userToken;

    private static String userPhoneNumber;
    private static String userPassword;

    @When("User click create account button on landing page")
    public void userClickCreateAccountButtonOnLandingPage() {
        landingPage.clickCreateAccountButton();
    }

    @When("User is on register page")
    public void userIsOnRegisterPage() {
        registerPage.isOnPage();
    }

    @When("User input {string} on phone number input field on register page")
    public void userInputOnPhoneNumberInputFieldOnRegisterPage(String phoneNumber) {
        userPhoneNumber = phoneNumber;
        registerPage.inputPhoneNumber(phoneNumber);
    }

    @When("User input {string} on full name input field on register page")
    public void userInputOnFullNameInputFieldOnRegisterPage(String fullName) {
        registerPage.inputFullName(fullName);
    }

    @When("User input {string} on email input field on register page")
    public void userInputOnEmailInputFieldOnRegisterPage(String email) {
        userEmail = email;
        registerPage.inputEmail(email);
    }

    @When("User input {string} on password input field on register page")
    public void userInputOnPasswordInputFieldOnRegisterPage(String password) {
        userPassword = password;
        registerPage.inputPassword(password);
    }

    @When("User input {string} on confirm password input field on register page")
    public void userInputOnConfirmPasswordInputFieldOnRegisterPage(String confirmPassword) {
        registerPage.inputConfirmPassword(confirmPassword);
    }

    @When("User input {string} on pin input field on register page")
    public void userInputOnPinInputFieldOnRegisterPage(String pin) {
        registerPage.inputPin(pin);
    }

    @When("User click create account button on register page")
    public void userClickCreateAccountButtonOnRegisterPage() {
        registerPage.clickCreateButton();
    }

    @When("User see the verification method window on register page")
    public void userSeeTheVerificationMethodWindowOnRegisterPage() {
        boolean status = registerPage.verificationWindowIsDisplayed();
        Assert.assertTrue(status);
    }

    @When("User click phone number button on verification method window")
    public void userClickPhoneNumberButtonOnVerificationMethodWindow() {
        registerPage.clickPhoneNumberButton();
    }

    @When("User is on OTP page")
    public void userIsOnOTPPage() {
        boolean status = otpPage.isOnPage();
        Assert.assertTrue(status);
    }

    @When("User get a valid OTP number")
    public void userGetAValidOTPNumber() {
        Response response = UserController.getOtp(userPhoneNumber);
        userOtpNumber = response.body().path("codeOtp");
    }

    @When("User enter valid OTP number on OTP page")
    public void userEnterValidOTPNumberOnOTPPage() {
        otpPage.inputPin(userOtpNumber);
    }

    @When("User click continue button on OTP page")
    public void userClickContinueButtonOnOTPPage() {
        otpPage.clickContinueButton();
    }

    @When("User is on success page")
    public void userIsOnSuccessPage() {
        boolean status = successPage.isOnPage();
        Assert.assertTrue(status);
    }

    @When("User click start using button on success page")
    public void userClickStartUsingButtonOnSuccessPage() {
        successPage.clickStartUsingButton();
    }

    @Then("User is registered as Quotes user")
    public void userIsRegisteredAsQuotesUser() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setNoTelepon(String.format("+62%s", userPhoneNumber));
        loginRequest.setPassword(userPassword);

        Response response = UserController.postLogin(loginRequest);
        String status = response.body().path("message");

        Assert.assertEquals("successfully", status);
    }

    public static String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public static String getUserPassword() {
        return userPassword;
    }

    @When("User click email button on verification method window")
    public void userClickEmailButtonOnVerificationMethodWindow() {
        registerPage.clickEmailButton();
    }

    @When("User get an email verification")
    public void userGetAnEmailVerification() {
        Response response = UserController.getToken(userEmail);
        userToken = response.body().path("codeVerify");
    }

    @When("User click an email verification")
    public void userClickAnEmailVerification() {
        Response response = UserController.getTokenConfirmation(userToken);
        response.getBody().prettyPrint();
    }

    @When("User click go to login page button on verification method window")
    public void userClickGoToLoginPageButtonOnVerificationMethodWindow() {
        registerPage.clickPhoneNumberButton();
    }
}
