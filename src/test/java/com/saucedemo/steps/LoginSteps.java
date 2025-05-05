package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductListPage;
import com.saucedemo.utils.BrowserFactory;
import com.saucedemo.utils.PageLoadsWithTitleExpectedCondition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductListPage productListPage;

    @Before
    public void setUp() {
        driver = BrowserFactory.getBrowser("Chrome");

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        productListPage = PageFactory.initElements(driver, ProductListPage.class);
    }

    @After
    public void tearDown() {
        BrowserFactory.closeBrowser();
    }

    @Given("user is on home page")
    public void user_is_on_home_page() {
        WebDriver driver = BrowserFactory.getBrowser("Chrome");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ProductListPage productListPage = PageFactory.initElements(driver, ProductListPage.class);

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
}
