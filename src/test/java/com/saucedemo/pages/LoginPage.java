package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;
    public String url = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    @CacheLookup
    WebElement userName;

    @FindBy(name = "password")
    @CacheLookup
    WebElement password;

    @FindBy(css = "#login-button")
    @CacheLookup
    WebElement loginButton;

    @FindBy(className = "error-message-container")
    @CacheLookup
    WebElement errorMessageContainer;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get(url);
    }

    public void login(String user, String pass) {
        userName.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }

    public String getUserNameInputClass() {
        return userName.getAttribute("class");
    }

    public String getPasswordInputClass() {
        return password.getAttribute("class");
    }

    public String getErrorMessage() {
        return errorMessageContainer.getText();
    }
}
