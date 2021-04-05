package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class CheckoutTests extends BaseTests {

    /**
     * End to End Test | This test case verifies that an order is completed from scratch successfully
     */
    @Test(groups = {"Regression", "Positive"})
    public void completeOrder() {
        this.getInventoryPage().clickProduct("Sauce Labs Fleece Jacket");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        this.getInventoryPage().clickCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setFirstName("Brayan");
        checkoutPage.setLastName("Ulloa");
        checkoutPage.setPostalCode("506");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();
        assertTrue(checkoutPage.getOrderCompletedMessageText()
                        .contains("THANK YOU FOR YOUR ORDER"),
                "The text does not match!");
    }

    /**
     * This test case verifies that an error message shows up when the checkout form is submitted without First Name
     */
    @Test(groups = {"Regression", "Negative"})
    public void submitCheckoutFormWithoutFirstName() {
        this.getInventoryPage().clickProduct("Sauce Labs Backpack");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        this.getInventoryPage().clickCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setFirstName("");
        checkoutPage.setLastName("Ulloa");
        checkoutPage.setPostalCode("506");
        checkoutPage.clickContinueButton();
        assertTrue(checkoutPage.getErrorMessageText()
                        .contains("Error: First Name is required"),
                "The text does not match!");
    }

    /**
     * This test case verifies that an error message shows up when the checkout form is submitted without Last Name
     */
    @Test(groups = {"Regression", "Negative"})
    public void submitCheckoutFormWithoutLastName() {
        this.getInventoryPage().clickProduct("Sauce Labs Bolt T-Shirt");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        this.getInventoryPage().clickCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setFirstName("Brayan");
        checkoutPage.setLastName("");
        checkoutPage.setPostalCode("506");
        checkoutPage.clickContinueButton();
        assertTrue(checkoutPage.getErrorMessageText()
                        .contains("Error: Last Name is required"),
                "The text does not match!");
    }

    /**
     * This test case verifies that an error message shows up when the checkout form is submitted without Postal Code
     */
    @Test(groups = {"Regression", "Negative"})
    public void submitCheckoutFormWithoutPostalCode() {
        this.getInventoryPage().clickProduct("Sauce Labs Bike Light");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        this.getInventoryPage().clickCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setFirstName("Brayan");
        checkoutPage.setLastName("Ulloa");
        checkoutPage.setPostalCode("");
        checkoutPage.clickContinueButton();
        assertTrue(checkoutPage.getErrorMessageText()
                        .contains("Error: Postal Code is required"),
                "The text does not match!");
    }

    /**
     * This test case verifies that the "CANCEL" button from the Checkout Page works as expected
     */
    @Test(groups = {"Regression", "Positive"})
    public void cancelButton() {
        this.getInventoryPage().clickProduct("Sauce Labs Onesie");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        this.getInventoryPage().clickCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCancelButton();
        assertTrue(cartPage.getSubheaderText()
                        .contains("YOUR CART"),
                "Subheader text is incorrect!");
    }
}
