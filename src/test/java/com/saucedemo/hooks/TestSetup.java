package com.saucedemo.hooks;

import com.saucedemo.utils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class TestSetup {
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserFactory.getBrowser("Firefox");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        BrowserFactory.closeBrowser();
    }
}
