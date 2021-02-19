package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePages {

    public WebDriver driver;

    public BasePages (WebDriver driver){
        this.driver = driver;
    }

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");

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


}
