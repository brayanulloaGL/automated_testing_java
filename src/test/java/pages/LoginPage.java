package pages;

import base.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePages {

    /**
     * Web Elements are defined below
     */
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By credentialsSection = By.id("login_credentials");
    private final By errorMessage = By.cssSelector("[data-test='error']");

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
    public void setUsername(String username){
        WebElement text = driver.findElement(usernameField);
        text.clear();
        text.sendKeys(new CharSequence[]{username});
    }

    public void setPassword(String password){
        WebElement text = driver.findElement(passwordField);
        text.clear();
        text.sendKeys(new CharSequence[]{password});
    }

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
