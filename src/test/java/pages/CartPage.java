package pages;

import base.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePages {

    /**
     * Web Elements are defined below
     */

    private By continueShoppingButton = By.linkText("CONTINUE SHOPPING");
    private By checkoutButton = By.cssSelector(".checkout_button");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By quantityProducts = By.cssSelector(".cart_quantity");
    private By subheader = By.cssSelector(".subheader");

    /**
     * This is the constructor of the Cart Page
     *
     * @param driver this parameter will be used in the following constructor so that way all the methods from this class have access to it
     */

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Functions or methods are defined below
     */

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public String getContinueShoppingButtonText() {
        return driver.findElement(continueShoppingButton).getText();
    }

    public String getCheckoutButtonText() {
        return driver.findElement(checkoutButton).getText();
    }

    public String getCartBadgeText() {
        return driver.findElement(cartBadge).getText();
    }

    public String getSubheaderText() {
        return driver.findElement(subheader).getText();
    }

    public String getQuantityProductsText() {
        return driver.findElement(quantityProducts).getText();
    }
}
