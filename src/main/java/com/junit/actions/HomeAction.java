package com.junit.actions;

import com.junit.driver.DriverManager;
import com.junit.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class HomeAction extends BaseAction {
    private final HomePage homePage;

    public HomeAction() {
        super();
        homePage = new HomePage(getDriver());
    }

    public void getAllowAllCookiesButton() {
        WebElement element = homePage.getAllowAllCookiesButton();
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void menuSection() {
        WebElement element = homePage.getDocsMenu();
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void menuChildItem() {
        WebElement element=homePage.getGherkinSyntaxItem();
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
