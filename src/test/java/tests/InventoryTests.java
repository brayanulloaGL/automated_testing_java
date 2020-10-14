package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class InventoryTests extends BaseTests {

    /**
     * Positive scenario
     * This test case verifies the name of a product
     */
    @Test
    public void correctItemName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.getRandomProductText()
                        .contains("Sauce Labs Backpack"),
                "The name of the item 4 is not correct!");
    }

    /**
     * Positive scenario
     * This test case verifies that a product is added to the cart successfully (from the Inventory page)
     */
    @Test
    public void productAddedToCart(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartButton("Sauce Labs Backpack");
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();
        assertTrue(cartPage.getQuantityProductsText()
                        .contains("1"),
                "No item has been added to the cart");
    }

    /**
     * Positive scenario
     * This test case verifies the "LOGOUT" functionality
     */
    @Test
    public void logout(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickMenuButton();
        inventoryPage.clickLogoutButton();
        assertTrue(loginPage.getCredentialsSectionText()
                        .contains("Accepted usernames are:"),
                "The text of this section has been updated!");
    }
}
