package demo.pages;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class HomePage {
    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        WebElement scanImage = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("iv_scan")));
        return scanImage.isDisplayed();
    }

    public void clickDataPackage() {
        AndroidElement menu = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("cl_data_package"));

        menu.click();
    }
}
