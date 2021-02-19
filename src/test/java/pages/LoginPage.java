package pages;

import base.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePages {

    /**
     * Web Elements are defined below
     */
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By credentialsSection = By.id("login_credentials");
    private By errorMessage = By.cssSelector("[data-test='error']");

    /**
     * This is the constructor of the Login Page
     * @param driver this parameter will be used in the following constructor so that way all the methods from this class have access to it
     */

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Functions or methods are defined below
     */
    // Llamar metodos de BasePage aca?

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String getErrorMessageText(){
        return driver.findElement(errorMessage).getText();
    }

    public String getCredentialsSectionText(){
        return driver.findElement(credentialsSection).getText();
    }
}
