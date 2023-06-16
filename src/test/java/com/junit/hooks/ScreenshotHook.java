package com.junit.hooks;

import com.junit.driver.DriverManager;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotHook {
    @After
    public void takeScreenshot(Scenario scenario){
//        scenario.write(DriverManager.getDriver().getCurrentUrl());
        byte[] screenshot=((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
       String s = "image/png";
        scenario.attach(screenshot, s, scenario.getName());
    }
}
