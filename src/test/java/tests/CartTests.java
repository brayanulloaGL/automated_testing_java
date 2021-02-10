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
    // I recommend to use groups in all test cases, to mark test cases as regression, smoke, etc
    @Test
    public void continueShoppingButtonAvailable(){
        //This apply for all test cases in this suite
        //
        // 1.
        // this lines are duplicated in all test cases, you can create a method or hook (before_method or so)
        // to put this code and reuse it in other test cases
        // 2.
        // I would recommend to use the testng parameters to retrieve the username
        // 3.
        // I would recommend to avoid having the password hardcoded in the code in the repository, there are other options
        // like env variables, send the password by command line when using the mvn command
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCart();

        // (OPTIONAL) in this case you can use it in the assert instead of assigning it into a variable because it is
        // used just one time, so it does not make sense to create a variable in these cases,
        // it is a common mistake that people do, but you can avoid it
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
