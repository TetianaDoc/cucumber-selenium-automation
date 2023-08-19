package com.junit.actions;

import com.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BaseAction {
    private static final String CUCUMBER_URL = "https://cucumber.io/";

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    BaseAction() {
        driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void openCucumberWebsite() {
        driver.get(CUCUMBER_URL);
    }

    public WebElement findElement(By by){
        return DriverManager.getDriver().findElement(by);
    }
    public List<WebElement> findElements(By by){
        return DriverManager.getDriver().findElements(by);
    }
    public boolean isElementDisplayed(By by){
        return !findElements(by).isEmpty();
    }
}
