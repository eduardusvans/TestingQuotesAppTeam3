package demo.pages;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class LandingPage {

    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 15);
        WebElement loginButton = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("btn_login_account")));
        return loginButton.isDisplayed();
    }

    public void clickLoginToAccountButton() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("btn_login_account"));

        button.click();
    }

    public void clickCreateAccountButton() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("btn_create_account"));

        button.click();
    }
}
