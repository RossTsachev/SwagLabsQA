package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductListPage {
    WebDriver driver;
    public String url = "https://www.saucedemo.com/inventory.html";
    public String title = "Swag Labs";

    @FindBy(xpath = "//div[@class='inventory_list']/div[@class='inventory_item'][1]//button")
    @CacheLookup
    WebElement firstItemAddToCartButton;

    @FindBy(xpath = "//div[@class='inventory_list']/div[@class='inventory_item'][1]//div[@class='inventory_item_name ']")
    @CacheLookup
    WebElement firstItemNameContainer;

    @FindBy(xpath = "//div[@class='inventory_list']/div[@class='inventory_item'][1]//div[@class='inventory_item_price']")
    @CacheLookup
    WebElement firstItemPriceContainer;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get(url);
    }

    public void addFirstItemToCart() {
        firstItemAddToCartButton.click();
    }

    public String getFirstItemName() {
        return firstItemNameContainer.getText();
    }

    public String getFirstItemPrice() {
        return firstItemPriceContainer.getText().replace("$", "");
    }
}
