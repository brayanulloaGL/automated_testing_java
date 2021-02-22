package tests;

import base.BasePages;
import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    /**
     * This test case verifies the "LOGIN" with valid credentials
     */
    @Test(groups = {"Login", "Positive" })
    public void validCredentials(){
        assertTrue(this.getInventoryPage().getInventoryContainerText()
                        .contains("Products"),
                "The text from the inventory container is incorrect!");
    }

    /**
     * This test case verifies the "LOGIN" with locked credentials
     */

    @Test(groups = {"Login", "Negative" })
    public void lockedCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("wrong_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getErrorMessageText()
                        .contains("Epic sadface: Sorry, this user has been locked out."),
                "Credentials are not locked!");
    }

    /**
     * This test case verifies the "LOGIN" with invalid credentials
     */
    @Test(groups = {"Login", "Negative" })
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
