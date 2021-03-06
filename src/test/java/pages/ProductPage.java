package pages;

import base.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePages {

    /**
     * Web Elements are defined below
     */
    private By productPrice = By.cssSelector(".inventory_details_price");
    private By backButton = By.id("back-to-products");
    private By addToCartButton = By.cssSelector(".btn_inventory");

    /**
     * This is the constructor of the Login Page
     *
     * @param driver this parameter will be used in the following constructor so that way all the methods from this class have access to it
     */

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Functions or methods are defined below
     */

    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getProductPriceText() {
        return driver.findElement(productPrice).getText();
    }
}



