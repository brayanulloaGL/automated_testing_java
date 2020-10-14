package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CartTests extends BaseTests {

    /**
     * Positive scenario
     * This test case verifies that the "CONTINUE SHOPPING" button is available on the Cart page
     */
    @Test
    public void continueShoppingButtonAvailable(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();
        String text = cartPage.getContinueShoppingButtonText();
        assertEquals(text, "CONTINUE SHOPPING", "Button is not available!");
    }

    /**
     * Positive scenario
     * This test case verifies that the "CHECKOUT" button is available on the Cart page
     */
    @Test
    public void checkoutButtonAvailable(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();
        String text = cartPage.getCheckoutButtonText();
        assertEquals(text, "CHECKOUT", "Checkout button is not available!");
    }

    /**
     * Positive scenario
     * This test case verifies that the cart badge shows up as soon as any product is added to the cart
     */
    @Test
    public void cartBadge(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickProduct("Sauce Labs Onesie");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.getCartBadgeText()
                        .contains("1"),
                "Any item has been added to the cart");
    }
}
