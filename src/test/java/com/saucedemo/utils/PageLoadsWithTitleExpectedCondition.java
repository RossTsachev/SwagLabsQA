package com.saucedemo.utils;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class PageLoadsWithTitleExpectedCondition implements ExpectedCondition<Boolean> {
    private final String pageTitle;

    public PageLoadsWithTitleExpectedCondition(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        boolean isPageLoaded = "complete".equals(((JavascriptExecutor) driver).executeScript("return document.readyState"));

        if (!isPageLoaded) {
            return false;
        }

        String currentTitle = driver.getTitle();

        return currentTitle != null && !currentTitle.isEmpty() && currentTitle.contains(pageTitle);
    }
}
