package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

import static org.testng.Assert.assertTrue;

public class ProductTests extends BaseTests {

    /**
     * This test case verifies that the price of a product is correct on the Product page
     */
    @Test(groups = {"UI", "Positive"})
    public void correctProductPrice() {
        this.getInventoryPage().clickProduct("Sauce Labs Bolt T-Shirt");
        ProductPage productPage = new ProductPage(driver);
        assertTrue(productPage.getProductPriceText()
                        .contains("15.99"),
                "The price of the item 1 is not correct!");
    }

    /**
     * This test case verifies that a product is added to the cart successfully (from the Product page)
     */
    @Test(groups = {"Regression", "Positive"})
    public void productAddedToCart() {
        this.getInventoryPage().clickProduct("Sauce Labs Bike Light");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        this.getInventoryPage().clickCart();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.getQuantityProductsText()
                        .contains("1"),
                "No item has been added to the cart");
    }

    /**
     * this test case verifies the "BACK" button functionality on the Product page
     */
    @Test(groups = {"Regression", "Positive"})
    public void backButton() {
        this.getInventoryPage().clickProduct("Sauce Labs Onesie");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickBackButton();
        assertTrue(this.getInventoryPage().getInventoryContainerText()
                        .contains("Products"),
                "The text from the inventory container is incorrect!");
    }
}
