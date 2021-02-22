package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class InventoryTests extends BaseTests {

    /**
     * This test case verifies the name of a product
     */
    @Test(groups = { "UI", "Positive" })
    public void correctItemName(){
        assertTrue(this.getInventoryPage().getRandomProductText()
                        .contains("Sauce Labs Backpack"),
                "The name of the item 4 is not correct!");
    }

    /**
     * This test case verifies that a product is added to the cart successfully (from the Inventory page)
     */
    @Test(groups = { "Smoke", "Positive" })
    public void productAddedToCart(){
        this.getInventoryPage().clickAddToCartButton("Sauce Labs Backpack");
        this.getInventoryPage().clickCart();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.getQuantityProductsText()
                        .contains("1"),
                "No item has been added to the cart");
    }

    /**
     * This test case verifies the "LOGOUT" functionality
     */
    @Test(groups = { "Regression", "Smoke" })
    public void logout(){
        this.getInventoryPage().clickMenuButton();
        this.getInventoryPage().clickLogoutButton();
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.getCredentialsSectionText()
                        .contains("Accepted usernames are:"),
                "The text of this section has been updated!");
    }
}
