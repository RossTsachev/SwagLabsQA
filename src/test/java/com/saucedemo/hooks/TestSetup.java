package com.saucedemo.hooks;

import com.saucedemo.utils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class TestSetup {
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserFactory.getBrowser("Chrome");
    }

    @After
    public void tearDown() {
        BrowserFactory.closeBrowser();
    }
}
