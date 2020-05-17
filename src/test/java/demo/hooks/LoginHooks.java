package demo.hooks;

import demo.controller.UserController;
import demo.driver.AndroidDriverInstance;
import demo.request.LogoutRequest;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.restassured.response.Response;

import static demo.steps_definitions.LoginStepDefinitions.getUserPassword;
import static demo.steps_definitions.LoginStepDefinitions.getUserPhoneNumber;

public class LoginHooks {

    @After(value = "@LogoutHookL")
    public void logoutAccount(){
        String phoneNumber = String.format("+62%s", getUserPhoneNumber());
        String password = getUserPassword();
        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setNoTelepon(phoneNumber);
        logoutRequest.setPassword(password);

        Response response = UserController.postLogout(logoutRequest);
        response.getBody().prettyPrint();
    }

}
