package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CartTests extends BaseTests {

    /**
     * This test case verifies that the "CONTINUE SHOPPING" button is available on the Cart page
     */
    @Test(groups = {"UI", "Positive"})
    public void continueShoppingButtonAvailable() {
        this.getInventoryPage().clickCart();
        CartPage cartPage = new CartPage(driver);
        String text = cartPage.getContinueShoppingButtonText();
        assertEquals(text, "CONTINUE SHOPPING", "Button is not available!");
    }

    /**
     * This test case verifies that the "CHECKOUT" button is available on the Cart page
     */
    @Test(groups = {"UI", "Positive"})
    public void checkoutButtonAvailable() {
        this.getInventoryPage().clickCart();
        CartPage cartPage = new CartPage(driver);
        String text = cartPage.getCheckoutButtonText();
        assertEquals(text, "CHECKOUT", "Checkout button is not available!");
    }

    /**
     * This test case verifies that the cart badge shows up as soon as any product is added to the cart
     */
    @Test(groups = {"Regression", "Positive"})
    public void cartBadge() {
        this.getInventoryPage().clickProduct("Sauce Labs Onesie");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.getCartBadgeText()
                        .contains("1"),
                "Any item has been added to the cart");
    }
}
