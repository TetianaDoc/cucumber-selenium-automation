package com.junit.hooks;

import com.junit.driver.DriverManager;
import org.junit.After;
import org.junit.Before;

public class DriverHooks {
    @After
    public void quitDriver(){
        DriverManager.quitDriver();
    }
}
