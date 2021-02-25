package pages;

import base.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePages {

    /**
     * Web Elements are defined below
     */
    private By inventoryContainer = By.id("inventory_filter_container");
    private By randomProduct = By.id("item_4_title_link");
    private By logout = By.id("logout_sidebar_link");
    private By menuButton = By.cssSelector(".bm-burger-button");
    private By product = By.cssSelector(".inventory_item_name");
    private By addToCartButton = By.cssSelector(".btn_inventory");
    private By cart = By.cssSelector(".fa-shopping-cart");
    private String productContainer = "//div[@class='inventory_item_name'][text()='%s']/ancestor::div[@class='inventory_item']";

    /**
     * This is the constructor of the Inventory Page
     *
     * @param driver this parameter will be used in the following constructor so that way all the methods from this class have access to it
     */

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Functions or methods are defined below
     */

    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }

    public void clickCart() {
        driver.findElement(cart).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logout).click();
    }

    private WebElement getProductContainerElement(String productName) {
        String productContainerElement = String.format(productContainer, productName);
        return driver.findElement(By.xpath(productContainerElement));
    }

    public void clickProduct(String productName) {
        getProductContainerElement(productName).findElement(product).click();
    }

    public void clickAddToCartButton(String productName) {
        getProductContainerElement(productName).findElement(addToCartButton).click();
    }

    public String getInventoryContainerText() {
        return driver.findElement(inventoryContainer).getText();
    }

    public String getRandomProductText() {
        return driver.findElement(randomProduct).getText();
    }
}
