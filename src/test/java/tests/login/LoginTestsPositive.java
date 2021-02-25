package tests.login;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.*;

public class LoginTestsPositive extends BaseTests {

    /**
     * This test case verifies the "LOGIN" with valid credentials
     */

    @Test(groups = {"Login", "Positive" })
    public void validCredentials(){
        assertTrue(this.getInventoryPage().getInventoryContainerText()
                        .contains("Products"),
                "The text from the inventory container is incorrect!");
    }
}
