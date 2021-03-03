package tests.login;

import base.BaseTests;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.testng.Assert.*;

public class LoginTestsPositive extends BaseTests {

    Logger logger = LogManager.getLogger(LoginTestsPositive.class);


    /**
     * This test case verifies the "LOGIN" with valid credentials
     */
    @Test(groups = {"Regression", "Positive"})
    public void validCredentials() {
        logger.info("INITIALIZING TEST");
        assertTrue(this.getInventoryPage().getInventoryContainerText()
                        .contains("Products"),
                "The text from the inventory container is incorrect!");
    }
}
