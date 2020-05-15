package demo.hooks;

import demo.controller.UserController;
import demo.driver.AndroidDriverInstance;
import demo.request.LogoutRequest;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.restassured.response.Response;

import static demo.steps_definitions.RegisterStepDefinitions.getUserPassword;
import static demo.steps_definitions.RegisterStepDefinitions.getUserPhoneNumber;

public class RegisterHooks {

    @After(value = "@Register and @LogoutHook")
    public void logoutAccount(){
        String phoneNumber = String.format("+62%s", getUserPhoneNumber());
        String password = getUserPassword();
        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setNoTelepon(phoneNumber);
        logoutRequest.setPassword(password);

        Response response = UserController.postLogout(logoutRequest);
        response.getBody().prettyPrint();
    }

    @After(value = "@Register and @DeleteHook")
    public void deleteAccount(){
        Response response = UserController.deleteUser(getUserPhoneNumber());
        response.getBody().prettyPrint();
    }

}
