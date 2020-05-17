package demo.pages;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class RegisterPage {

    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        WebElement phoneNumberInput = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("etPhoneRegister")));
        return phoneNumberInput.isDisplayed();
    }

    public void inputPhoneNumber(String phoneNumberInput) {
        AndroidElement input = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("etPhoneRegister"));

        input.sendKeys(phoneNumberInput);
    }

    public void inputFullName(String fullNameInput) {
        AndroidElement input = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("et_full_name"));

        input.sendKeys(fullNameInput);
    }

    public void inputEmail(String emailInput) {
        AndroidElement input = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("et_email"));

        input.sendKeys(emailInput);
    }

    public void inputPassword(String PasswordInput) {
        AndroidElement input = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("et_password"));

        input.sendKeys(PasswordInput);
    }

    public void inputConfirmPassword(String confirmPasswordInput) {
        AndroidElement input = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("et_confirmpassword"));

        input.sendKeys(confirmPasswordInput);
    }

    public void inputPin(String pinInput) {
        AndroidElement input = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("et_pin"));

        input.sendKeys(pinInput);
    }

    public void clickCreateButton() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("btn_register"));

        button.click();
    }

    public boolean verificationWindowIsDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(androidDriver, 3);
            WebElement emailButton = wait
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("btn_choose_email")));
            return emailButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickEmailButton() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("btn_choose_email"));

        button.click();
    }

    public void clickPhoneNumberButton() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("btn_choose_phone"));

        button.click();
    }

    public static void scrollDown() {
        AndroidElement screen = AndroidDriverInstance
                .androidDriver
                .findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup"));
        Point center =  screen.getCenter();
        int startX = 20;
        int startY = center.getY() + 400;
        int endX = 20;
        int endY = center.getY() - 400;
        TouchAction scroll = new TouchAction(androidDriver);
        scroll.press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY)).perform();
    }


}
