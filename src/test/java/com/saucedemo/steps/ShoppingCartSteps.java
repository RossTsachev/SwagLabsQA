package com.saucedemo.steps;

import com.saucedemo.hooks.TestSetup;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductListPage;
import com.saucedemo.pages.ShoppingCartPage;
import com.saucedemo.utils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class ShoppingCartSteps {

    WebDriver driver = TestSetup.driver;
    LoginPage loginPage;
    ProductListPage productListPage;
    ShoppingCartPage shoppingCartPage;
    String expectedCartItemName;
    String expectedCartItemPrice;

    public ShoppingCartSteps() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        productListPage = PageFactory.initElements(driver, ProductListPage.class);
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
    }

    @Given("user has logged into the site")
    public void user_has_logged_into_the_site() {
        loginPage.goToPage();
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("user adds item to shopping cart")
    public void user_adds_item_to_shopping_cart() {
        productListPage.addFirstItemToCart();
        expectedCartItemName = productListPage.getFirstItemName();
        expectedCartItemPrice = productListPage.getFirstItemPrice();
    }

    @When("user goes to shopping cart page")
    public void user_goes_to_shopping_cart_page() {
        shoppingCartPage.goToPage();
    }

    @Then("user can see the item in the shopping cart")
    public void user_can_see_the_item_in_the_shopping_cart() {
        Assert.assertEquals(1, shoppingCartPage.getCartItemCount());
        Assert.assertEquals(expectedCartItemName, shoppingCartPage.getFirstItemName());
        Assert.assertEquals(expectedCartItemPrice, shoppingCartPage.getFirstItemPrice());
    }
}
