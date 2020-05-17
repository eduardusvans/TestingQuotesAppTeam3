package demo.steps_definitions;

import demo.controller.UserController;
import demo.pages.DataPackagePage;
import demo.pages.HomePage;
import demo.response.TransactionHistoryResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

import static demo.steps_definitions.LoginStepDefinitions.getUserPhoneNumber;

public class TransactionStepDefinitions {

    HomePage homePage = new HomePage();
    DataPackagePage dataPackagePage = new DataPackagePage();

    String userPhoneNumber = getUserPhoneNumber();
    String chosenPhoneNumber;
    int chosenDataPackage;


    @When("User click data package on transaction column on home page")
    public void userClickDataPackageOnTransactionColumnOnHomePage() {
        homePage.clickDataPackage();
    }

    @When("User is on data package page")
    public void userIsOnDataPackagePage() {
        boolean status = dataPackagePage.isOnPage();
        Assert.assertTrue(status);
    }

    @When("User input {string} as chosen phone number on phone number input field on data package page")
    public void userInputAsChosenPhoneNumberOnPhoneNumberInputFieldOnDataPackagePage(String phoneNumber) {
        chosenPhoneNumber = phoneNumber;
        dataPackagePage.inputChosenPhoneNumber(phoneNumber);
    }

    @When("User see data package list on data package page")
    public void userSeeDataPackageListOnDataPackagePage() {
        boolean status = dataPackagePage.dataPackageIsDisplayed();
        Assert.assertTrue(status);
    }

    @When("User click data package that has {string} on its price tag")
    public void userClickDataPackageThatHasOnItsPriceTag(String priceTag) {
        chosenDataPackage = Integer.parseInt(priceTag
                .replace("Rp","")
                .replace(".",""));
        dataPackagePage.clickChosenDataPackage(priceTag);
    }

    @When("User see transaction pop up window")
    public void userSeeTransactionPopUpWindow() {
        boolean status = dataPackagePage.transactionWindowIsDisplayed();
        Assert.assertTrue(status);
    }

    @When("User click choose method button on transaction pop up window")
    public void userClickChooseMethodButtonOnTransactionPopUpWindow() {
        dataPackagePage.clickChooseMethodButton();
    }

    @When("User click wallet balance method radio button on transaction pop up window")
    public void userClickWalletBalanceMethodRadioButtonOnTransactionPopUpWindow() {
        dataPackagePage.clickWalletBalanceMethod();
    }

    @When("User input {string} on pin input field on transaction pop up window")
    public void userInputOnPinInputFieldOnTransactionPopUpWindow(String pin) {
        dataPackagePage.inputPin(pin);
    }

    @When("User click pay now button on transaction pop up window")
    public void userClickPayNowButtonOnTransactionPopUpWindow() {
        dataPackagePage.clickChooseMethodButton();
    }

    @Then("User transaction is success")
    public void userTransactionIsSuccess() {
        dataPackagePage.waitABit(3000);
        Response response = UserController.getTransactionHistory(userPhoneNumber);
        String actualChosenNumber = response.getBody().path("history.last().nomorPaketData");
        int actualPriceTag = response.getBody().path("history.last().harga");
        String transactionStatus = response.getBody().path("history.last().message");
        Assert.assertEquals(String.format("+62%s", chosenPhoneNumber), actualChosenNumber);
        Assert.assertEquals(chosenDataPackage, actualPriceTag);
        Assert.assertEquals("Transaction successfully", transactionStatus);
    }

}
