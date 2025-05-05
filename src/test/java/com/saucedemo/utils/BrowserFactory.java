package com.saucedemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;

        switch (browserName) {
            case "Chrome":
                driver = drivers.get("Chrome");
                if (driver == null || isDriverInvalid(driver)) {
                    System.setProperty("webdriver.chrome.driver", "c:/Code/BrowserDrivers/chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    drivers.put("Chrome", driver);
                }
                break;
            case "Firefox":
                driver = drivers.get("Firefox");
                if (driver == null || isDriverInvalid(driver)) {
                    System.setProperty("webdriver.gecko.driver", "c:/Code/BrowserDrivers/geckodriver.exe");
                    driver = new FirefoxDriver();
                    drivers.put("Firefox", driver);
                }
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }

        return driver;
    }

    public static void closeBrowser() {
        for (String key : drivers.keySet()) {
            drivers.get(key).close();
            drivers.get(key).quit();
        }
    }

    private static boolean isDriverInvalid(WebDriver driver) {
        try {
            return driver.getWindowHandles().isEmpty();  // Check if session is lost
        } catch (Exception e) {
            return true;  // If an exception occurs, the driver is likely invalid
        }
    }
}
