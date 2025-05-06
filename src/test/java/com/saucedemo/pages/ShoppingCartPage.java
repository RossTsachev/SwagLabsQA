package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ShoppingCartPage {
    WebDriver driver;
    public String url = "https://www.saucedemo.com/cart.html";

    @FindBy(xpath = "//div[@class='cart_list']/div[@class='cart_item']")
    @CacheLookup
    List<WebElement> cartItems;

    @FindBy(xpath = "//div[@class='cart_item'][1]/div[@class='cart_item_label']/a")
    @CacheLookup
    WebElement firstItemName;

    @FindBy(xpath = "//div[@class='cart_item'][1]//div[@class='inventory_item_price']")
    @CacheLookup
    WebElement firstItemPrice;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get(url);
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public String getFirstItemName() {
        return firstItemName.getText();
    }

    public String getFirstItemPrice() {
        return firstItemPrice.getText().replace("$", "");
    }
}
