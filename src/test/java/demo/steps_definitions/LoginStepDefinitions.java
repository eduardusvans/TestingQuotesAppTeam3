package demo.steps_definitions;

import demo.pages.HomePage;
import demo.pages.LoginPage;
import demo.pages.NavBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    NavBar navBar = new NavBar();
    HomePage homePage = new HomePage();

    private static String userPhoneNumber;
    private static String userPassword;

    @Given("User is on Quotes App starting page")
    public void userIsOnQuotesAppStartingPage() {
        boolean pageStatus = loginPage.isOnStartingPage();
        Assert.assertTrue(pageStatus);
    }

    @When("User click login to account button on starting page")
    public void userClickLoginToAccountButtonOnStartingPage() {
        loginPage.clickLoginAccount();
    }

    @When("User is on Quotes App login page")
    public void userIsOnQuotesAppLoginPage() {
        boolean pageStatus = loginPage.isOnLoginPage();
        Assert.assertTrue(pageStatus);
    }

    @When("User input {string} on phone number input field on login page")
    public void userInputOnPhoneNumberInputFieldOnLoginPage(String phoneNumber) {
        userPhoneNumber = phoneNumber;
        loginPage.inputPhoneNumber(phoneNumber);
    }

    @When("User input {string} on password input field on login page")
    public void userInputOnPasswordInputFieldOnLoginPage(String password) {
        userPassword = password;
        loginPage.inputPassword(password);
    }

    @When("User click login button on login page")
    public void userClickLoginButtonOnLoginPage() {
        loginPage.clickLoginButton();
    }

    @Then("User is on home page")
    public void userIsOnHomePage() {
        boolean navStatus = navBar.isDisplayed();
        Assert.assertTrue(navStatus);

        navBar.goToHomePage();

        boolean pageStatus = homePage.isOnPage();
        Assert.assertTrue(pageStatus);
    }

    public static String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public static String getUserPassword() {
        return userPassword;
    }

}
