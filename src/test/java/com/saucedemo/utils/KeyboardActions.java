package com.saucedemo.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
    private Actions actions;

    public KeyboardActions(WebDriver driver) {
        this.actions = new Actions(driver);
    }

    public void pressKey(Keys key) {
        actions.sendKeys(key).perform();
    }

    public void pressKey(String chars) {
        actions.sendKeys(chars).perform();
    }
}
