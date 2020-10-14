package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ProductPage;

import static org.testng.Assert.assertTrue;

public class ProductTests extends BaseTests {

    /**
     * Positive scenario
     * This test case verifies that the price of a product is correct on the Product page
     */
    @Test
    public void correctProductPrice(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickProduct("Sauce Labs Bolt T-Shirt");
        ProductPage productPage = new ProductPage(driver);
        assertTrue(productPage.getProductPriceText()
                        .contains("15.99"),
                "The price of the item 1 is not correct!");
    }

    /**
     * Positive scenario
     * This test case verifies that a product is added to the cart successfully (from the Product page)
     */
    @Test
    public void productAddedToCart(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickProduct("Sauce Labs Bike Light");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();
        assertTrue(cartPage.getQuantityProductsText()
                        .contains("1"),
                "No item has been added to the cart");
    }

    /**
     * Positive scenario
     * this test case verifies the "BACK" button functionality on the Product page
     */
    @Test
    public void backButton(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickProduct("Sauce Labs Onesie");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickBackButton();
        assertTrue(inventoryPage.getInventoryContainerText()
                        .contains("Products"),
                "The text from the inventory container is incorrect!");
    }
}
