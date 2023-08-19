package com.junit.pages;

import com.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;

import java.time.Duration;

import static java.lang.String.format;

public class HomePage extends BasePage {
    private static final String TEXT_PATTERN = "%s[contains(text(),'%s')]";
    private static final String COOKIES_SECTION = "//*[contains(@class, 'ch2-btn ch2-allow-all-btn ch2-btn-primary')]";
    private static final String MENU_SECTION = "//*[contains(@class,'nav-link')]";
    private static final String CHILD_MENU_ITEM = "//*[contains(@href,'gherkin')]";

//    public WebElement cookiesSection(String linkText) {
//        return findElement(By.xpath(format(COOKIES_SECTION, linkText)));
//    }
//
//    public WebElement menuSection(String linkText) {
//        return findElement(By.xpath(format(TEXT_PATTERN, MENU_SECTION, linkText)));
//    }
//
//    public WebElement menuChildItem(String linkText) {
//        return findElement(By.xpath(format(TEXT_PATTERN, CHILD_MENU_ITEM, linkText)));
//    }

    @FindBy(xpath = "//button[text() = 'Allow all cookies']")
    private WebElement allowAllCookiesButton;
    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle' and text()='Docs']")
    private WebElement docsMenu;
    @FindBy(css="a[href='/docs/gherkin/']")
    private WebElement gherkinSyntaxItem;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getGherkinSyntaxItem() {
        return gherkinSyntaxItem;
    }

    public void setGherkinSyntaxItem(WebElement gherkinSyntaxItem) {
        this.gherkinSyntaxItem = gherkinSyntaxItem;
    }

    public WebElement getAllowAllCookiesButton() {
        return allowAllCookiesButton;
    }

    public void setAllowAllCookiesButton(WebElement allowAllCookiesButton) {
        this.allowAllCookiesButton = allowAllCookiesButton;
    }

    public WebElement getDocsMenu() {
        return docsMenu;
    }

    public void setDocsMenu(WebElement docsMenu) {
        this.docsMenu = docsMenu;
    }
}
