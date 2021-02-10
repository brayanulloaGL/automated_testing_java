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

    // in this comments, provide a bried description of the parameter, for example the driver parameter
    // does not have description, take a look on all the code to see if there are more missing descriptions
    /**
     * This is the constructor of the Login Page
     * @param driver
     */
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // in this case for example, it it missing the username in the documentation of the method
    /**
     * Functions or methods are defined below
     */
    public void setUsername(String username){
        // APPLY THIS ON ALL PAGES
        // use this automation pattern here: https://github.com/SeleniumHQ/selenium/wiki/Bot-Style-Tests
        // "This means that if you find that commands aren't doing the Right Thing for your app, it's easy to change them."
        // In this case, you are doing a clear() call every single time you do a sendkeys(), so this pattern will help you to organize this better
        // check all pages and methods, and apply this if possible
        WebElement text = driver.findElement(usernameField);
        text.clear();
        text.sendKeys(username);
    }

    // add documentation on all methods, not just some of them, check for this in the entire project please
    public void setPassword(String password){
        WebElement text = driver.findElement(passwordField);
        text.clear();
        text.sendKeys(password);
    }

    public void clickLoginButton(){
        // APPLY THIS ON ALL PAGES
        // in this sort of methods, you are doing a navigation in positive scenarios when the user clicks on the login button
        // in these cases I suggest to return an instance of the page object of the target page.
        // For negative scenarios, there are 2 options, to have 2 methods (one with navigation and other one without navigation) or
        // to add a boolean parameter to the method and then if it is true then return
        // the instance of the next page object, otherwise return an instance of the login page.
        driver.findElement(loginButton).click();
    }

    public String getErrorMessageText(){
        return driver.findElement(errorMessage).getText();
    }

    public String getCredentialsSectionText(){
        return driver.findElement(credentialsSection).getText();
    }
}
