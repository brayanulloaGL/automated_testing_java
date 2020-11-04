package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private WebDriver driver;

    /**
     * Web Elements are defined below
     */
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By cancelButton = By.cssSelector(".btn_secondary");
    private By continueButton = By.cssSelector(".cart_button");
    private By errorMessage = By.cssSelector("[data-test='error']");
    private By finishButton = By.cssSelector(".cart_button");
    private By completeOrder = By.cssSelector(".complete-header");


    /**
     * This is the constructor of the Checkout Page
     * @param driver
     */
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Functions or methods are defined below
     */
    public void setFirstName(String firstName){
        WebElement text = driver.findElement(firstNameField);
        text.clear();
        text.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        WebElement text = driver.findElement(lastNameField);
        text.clear();
        text.sendKeys(lastName);
    }

    public void setPostalCode(String postalCode){
        WebElement text = driver.findElement(postalCodeField);
        text.clear();
        text.sendKeys(postalCode);
    }

    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

    public String getErrorMessageText(){
        return driver.findElement(errorMessage).getText();
    }

    public String getOrderCompletedMessageText(){
        return driver.findElement(completeOrder).getText();
    }
}
