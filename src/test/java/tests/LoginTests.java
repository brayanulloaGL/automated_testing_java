package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;


import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    /**
     * Positive scenario
     * This test case verifies the "LOGIN" with valid credentials
     */
    @Test(groups = { "Login", "Positive" })
    public void validCredentials(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(this.getSauceUserName());
        loginPage.setPassword(this.getSaucePassword());
        loginPage.clickLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.getInventoryContainerText()
                        .contains("Products"),
                "The text from the inventory container is incorrect!");
    }

    /**
     * Positive scenario
     * This test case verifies the "LOGIN" with locked credentials
     */
    @Test(groups = { "Login", "Negative" })
    public void lockedCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("locked_out_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getErrorMessageText()
                        .contains("Epic sadface: Sorry, this user has been locked out."),
                "Credentials are not locked!");
    }

    /**
     * Negative scenario
     * This test case verifies the "LOGIN" with invalid credentials
     */
    @Test(groups = { "Login", "Negative" })
    public void invalidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("wrong_user");
        loginPage.setPassword("wrong_pass");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getErrorMessageText()
                        .contains("Epic sadface: Username and password do not match any user in this service"),
                "The credentials entered are valid!");
    }
}
