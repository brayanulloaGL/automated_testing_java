package tests.login;

import base.BaseTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LogoutTests extends BaseTests {

    @AfterClass(alwaysRun = true)
    public void logout (){
    }

    /**
     * This test case verifies the "LOGOUT" functionality
     */
    @Test(groups = { "Regression", "Smoke" })
    public void logoutTest(){
        this.getInventoryPage().clickMenuButton();
        this.getInventoryPage().clickLogoutButton();
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.getCredentialsSectionText()
                        .contains("Accepted usernames are:"),
                "The text of this section has been updated!");
    }
}
