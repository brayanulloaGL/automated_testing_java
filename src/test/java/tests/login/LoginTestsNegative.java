package tests.login;

import base.BaseTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTestsNegative extends BaseTests {

    @BeforeMethod(alwaysRun = true)
    public void goHome() {
    }

    @AfterClass(alwaysRun = true)
    public void logout() {
    }
    //Override cae encima al metodo de BaseTest. Al caer encima el de BaseTest no se ejecuta

    /**
     * This test case verifies the "LOGIN" with locked credentials
     */
    @Test(groups = {"Regression", "Negative"})
    public void lockedCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(System.getenv("SAUCE_USERNAME_LOCKED"));
        loginPage.setPassword(System.getenv("SAUCE_PASSWORD_LOCKED"));
        loginPage.clickLoginButton();
        assertTrue(loginPage.getErrorMessageText()
                        .contains("Epic sadface: Sorry, this user has been locked out."),
                "Credentials are not locked!");
    }

    /**
     * This test case verifies the "LOGIN" with invalid credentials
     */
    @Test(groups = {"Regression", "Negative"})
    public void invalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("wrong_user");
        loginPage.setPassword("wrong_pass");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getErrorMessageText()
                        .contains("Epic sadface: Username and password do not match any user in this service"),
                "The credentials entered are valid!");
    }
}
