package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

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
     * @param driver
     */
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Functions or methods are defined below
     */
    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
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
