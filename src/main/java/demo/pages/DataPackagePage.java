package demo.pages;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class DataPackagePage {

    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        WebElement phoneNumberInput = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("etPhoneRegister")));
        return phoneNumberInput.isDisplayed();
    }

    public void inputChosenPhoneNumber(String phoneNumberInput) {
        AndroidElement input = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("etPhoneRegister"));

        input.sendKeys(phoneNumberInput);
    }

    public boolean dataPackageIsDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(androidDriver, 5);
            WebElement recyclerView = wait
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("recyler_view")));
            return recyclerView.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickChosenDataPackage(String priceTag) {
        boolean isFound = false;
        int counter = 0;
        while (!isFound && counter < 10){
                String xpath = "//android.widget.TextView[2]";
                List<AndroidElement> dataPackage = AndroidDriverInstance.androidDriver.findElements(By.xpath(xpath));
                for (AndroidElement price : dataPackage) {
                    if (price.getText().equalsIgnoreCase(priceTag)) {
                        price.click();
                        System.out.println("Found It!!");
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    scrollDown();
                    counter++;
                }
        }
    }

    public boolean transactionWindowIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        WebElement chooseMethodButton = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("btn_choose_method")));
        return chooseMethodButton.isDisplayed();
    }

    public void clickChooseMethodButton() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("btn_choose_method"));

        button.click();
    }

    public void clickWalletBalanceMethod() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("rb_wallet"));

        button.click();
    }

    public void inputPin(String pinInput) {
        AndroidElement input = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("et_pin"));

        input.sendKeys(pinInput);
    }

    public void waitABit(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void scrollDown() {
        AndroidElement screen = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("recyler_view"));
        Point center =  screen.getCenter();
        int startX = 70;
        int startY = center.getY() + 300;
        int endX = 70;
        int endY = center.getY() - 300;
        TouchAction scroll = new TouchAction(androidDriver);
        scroll.press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY)).perform();
    }

}
