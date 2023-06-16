package com.junit.pages;

import com.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class HomePage extends BasePage{
    private static final String CUCUMBER_URL="https://cucumber.io/";
    private static final String TEXT_PATTERN="%s[contains(text(),'%s')]";
    private static final String MENU_SECTION="//*[contains(@class,'nav-link')]";
    private static final String CHILD_MENU_ITEM="//*[contains(@href,'gherkin')]";

    public void openCucumberWebsite(){
        DriverManager.getDriver().get(CUCUMBER_URL);
    }
    public WebElement menuSection(String linkText){
        return findElement(By.xpath(format(TEXT_PATTERN, MENU_SECTION, linkText)));
    }
    public WebElement menuChildItem(String linkText){
        return findElement(By.xpath(format(TEXT_PATTERN, CHILD_MENU_ITEM, linkText)));
    }
}
