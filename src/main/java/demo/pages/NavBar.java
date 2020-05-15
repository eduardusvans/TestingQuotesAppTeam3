package demo.pages;

import demo.driver.AndroidDriverInstance;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class NavBar {
    public boolean isDisplayed() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        WebElement NavigationBar = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("bottom_navigation")));
        return NavigationBar.isDisplayed();
    }

    public void goToHistoryPage() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("page_2"));

        button.click();
    }

    public void goToHomePage() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("page_1"));

        button.click();
    }

    public void goToProfilePage() {
        AndroidElement button = AndroidDriverInstance
                .androidDriver
                .findElement(By.id("page_3"));

        button.click();
    }
}
