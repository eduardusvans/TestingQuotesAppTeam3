package demo.pages;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class SuccessPage {

    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        WebElement startUsingButton = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("btn_start_using")));
        return startUsingButton.isDisplayed();
    }

    public void clickStartUsingButton() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("btn_start_using"));

        button.click();
    }

}
