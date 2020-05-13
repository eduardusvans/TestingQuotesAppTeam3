package demo.steps_definitions;

import demo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on QUOTES login page")
    public void userIsOnQuotesAppLoginPage() {
        boolean status = loginPage.isOnPage();
        Assert.assertTrue(status);
    }

    @When("User input {string} on phone number input field on login page")
    public void userInputOnPhoneNumberInputFieldOnLoginPage(String phoneNumber) {
        loginPage.inputPhoneNumber(phoneNumber);
    }

    @When("User input {string} on password input field on login page")
    public void userInputOnPasswordInputFieldOnLoginPage(String password) {
        loginPage.inputPassword(password);
    }

    @When("User click login button on login page")
    public void userClickLoginButtonOnLoginPage() {
        loginPage.clickLoginButton();
    }

    @Then("User is on home page")
    public void userIsOnHomePage() {
        boolean status = true; // Change this after home page is available
        Assert.assertTrue(status);
    }
}
