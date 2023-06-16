package com.junit.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class DriverManager {
    private static final String CHROME_DRIVER_PATH = "src/main/resources/drivers/chromedriver";
    private static WebDriver driver;

    private DriverManager() {
    }

    private static void setupDriver() {
        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER_PATH);
        driver = new ChromeDriver(defaultChromeOptions());
        driver.manage().window().maximize();

    }

    private static ChromeOptions defaultChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        List<String> flags =
                Arrays.asList("--start-maximized",
                        "--incognito",
                        "--ignore-certificate-errors",
                        "--disable-gpu",
                        "--disable-extensions",
                        "--no-sandbox",
                        "--disable-dev-shm-usage",
//                        "--headless",
                        "--window-size=1440,900",
                        "--remote-allow-origins=*"
                );

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
//        chromePrefs.put("download.default_directory", USER_FOLDER_PATH);
//        chromePrefs.put(CapabilityType.LOGGING_PREFS, logs);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments(flags);
        return options;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setupDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
