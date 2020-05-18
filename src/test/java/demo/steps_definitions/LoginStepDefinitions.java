package demo.steps_definitions;

import demo.pages.HomePage;
import demo.pages.LandingPage;
import demo.pages.LoginPage;
import demo.pages.NavBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LandingPage landingPage = new LandingPage();
    LoginPage loginPage = new LoginPage();
    NavBar navBar = new NavBar();
    HomePage homePage = new HomePage();

    private static String userPhoneNumber;
    private static String userPassword;

    @Given("User is on Quotes Landing page")
    public void userIsOnQuotesLandingPage() {
        boolean pageStatus = landingPage.isOnPage();
        Assert.assertTrue(pageStatus);
    }

    @When("User click login to account button on landing page")
    public void userClickLoginToAccountButtonOnLandingPage() {
        landingPage.clickLoginToAccountButton();
    }

    @When("User is on login page")
    public void userIsOnLoginPage() {
        boolean pageStatus = loginPage.isOnPage();
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

    @When("User click login to account button on login page")
    public void userClickLoginToAccountButtonOnLoginPage() {
        loginPage.clickLoginToAccountButton();
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

    @Then("User is still on login page")
    public void userIsStillOnLoginPage() {
        loginPage.waitABit(5000);
        boolean pageStatus = loginPage.isOnPage();
        Assert.assertTrue(pageStatus);
    }
}
