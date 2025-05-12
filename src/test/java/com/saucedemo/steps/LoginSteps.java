package com.saucedemo.steps;

import com.saucedemo.hooks.TestSetup;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductListPage;
import com.saucedemo.utils.BrowserFactory;
import com.saucedemo.utils.KeyboardActions;
import com.saucedemo.utils.PageLoadsWithTitleExpectedCondition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class LoginSteps {
    WebDriver driver = TestSetup.driver;
    LoginPage loginPage;
    ProductListPage productListPage;
    KeyboardActions keyboardActions;

    public LoginSteps() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        productListPage = PageFactory.initElements(driver, ProductListPage.class);
        keyboardActions = new KeyboardActions(driver);
    }

    @Given("user is on home page")
    public void user_is_on_home_page() {
        loginPage.goToPage();
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("user is logged in to the site")
    public void user_is_logged_in_to_the_site() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(new PageLoadsWithTitleExpectedCondition(productListPage.title));
    }

    @Then("the product list page is displayed")
    public void the_product_list_page_is_displayed() {
        String expectedUrlAfterLogin = productListPage.url;
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrlAfterLogin, currentUrl);
    }

    @When("^user tries to log in with invalid (.*) and (.*)$")
    public void user_tries_to_log_in_with_invalid_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the url stays the same")
    public void the_url_stays_the_same() {
        String expectedUrlAfterLogin = loginPage.url;
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrlAfterLogin, currentUrl);
    }

    @Then("the input fields are highlighted in red")
    public void the_input_fields_are_highlighted_in_red() {
        Assert.assertTrue(loginPage.getUserNameInputClass().contains("error"));
        Assert.assertTrue(loginPage.getPasswordInputClass().contains("error"));
    }

    @Then("an error message is displayed")
    public void an_error_message_is_displayed() {
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @When("user presses Tab key")
    public void user_presses_Tab_key() {
        keyboardActions.pressKey(Keys.TAB);
    }

    @Then("the username field becomes active")
    public void the_username_field_becomes_active() {
        Assert.assertEquals(driver.switchTo().activeElement(), loginPage.getUserNameInput());
    }

    @When("user enters valid username")
    public void user_enters_valid_username() {
        keyboardActions.pressKey("standard_user");
    }

    @Then("the password field becomes active")
    public void the_password_field_becomes_active() {
        Assert.assertEquals(driver.switchTo().activeElement(), loginPage.getPasswordInput());
    }

    @When("user enters valid password")
    public void user_enters_valid_password() {
        keyboardActions.pressKey("secret_sauce");
    }

    @When("user presses Enter key")
    public void user_presses_Enter_key() {
        keyboardActions.pressKey(Keys.ENTER);
    }
}
