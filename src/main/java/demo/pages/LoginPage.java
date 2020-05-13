package demo.pages;

import static demo.driver.AndroidDriverInstance.androidDriver;
import demo.driver.AndroidDriverInstance;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 15);
        WebElement loginButton = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("btn_login")));
        return loginButton.isDisplayed();
    }

    public void inputPhoneNumber(String phoneNumberInput) {
        AndroidElement input = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("editText"));

        input.sendKeys(phoneNumberInput);
    }

    public void inputPassword(String passwordInput) {
        AndroidElement input = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("et_password"));

        input.sendKeys(passwordInput);
    }

    public void clickLoginButton() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("btn_login"));

        button.click();
    }

}
