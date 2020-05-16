package demo.pages;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class OtpPage {

    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        WebElement continueButton = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("btn_continue")));
        return continueButton.isDisplayed();
    }

    public void inputPin(String otpNumber) {
        for (int i = 1; i < otpNumber.length() + 1; i++) {
            AndroidElement input = AndroidDriverInstance
                    .androidDriver
                    .findElement(By.id(String.format("et_pin%s", i)));
            String pin = Character.toString(otpNumber.charAt(i - 1));
            input.sendKeys(pin);
        }
    }

    public void clickContinueButton() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("btn_continue"));

        button.click();
    }

}
