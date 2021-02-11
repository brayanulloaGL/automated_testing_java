package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    //Consider implement a single loggin method instead of calling this 3 
    
    public void setUsername(String username){
        WebElement text = driver.findElement(usernameField);
        text.clear();
        text.sendKeys(username);
    }

    public void setPassword(String password){
        WebElement text = driver.findElement(passwordField);
        text.clear();
        text.sendKeys(password);
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
