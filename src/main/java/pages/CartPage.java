package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CartPage {

    private WebDriver driver;

    /**
     * Web Elements are defined below
     */
    private By cart = By.cssSelector(".fa-shopping-cart");
    private By continueShoppingButton = By.linkText("CONTINUE SHOPPING");
    private By checkoutButton = By.cssSelector(".checkout_button");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By quantityProducts = By.cssSelector(".cart_quantity");
    private By subheader = By.cssSelector(".subheader");

    /**
     * This is the constructor of the Cart Page
     * @param driver
     */
    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Functions or methods are defined below
     */
    public void clickCart(){
        driver.findElement(cart).click();
    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

    public String getContinueShoppingButtonText(){
        return driver.findElement(continueShoppingButton).getText();
    }

    public String getCheckoutButtonText(){
        return driver.findElement(checkoutButton).getText();
    }

    public String getCartBadgeText(){
        return driver.findElement(cartBadge).getText();
    }

    public String getSubheaderText(){
        return driver.findElement(subheader).getText();
    }

    public String getQuantityProductsText(){
        return driver.findElement(quantityProducts).getText();
    }
}
