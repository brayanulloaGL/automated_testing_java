package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    public WebDriver driver;

    private String sauceUserName;
    private String saucePassword;

    /**
     * This configuration will be included in all of the test cases
     */

    @BeforeClass (alwaysRun = true)
    @Parameters ("browser")
    public void setUp(String browserName){

        this.setSauceUserName(System.getenv("SAUCE_USERNAME"));
        this.setSaucePassword(System.getenv("SAUCE_PASSWORD"));

        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }

        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); // Some elements are not interactable unless this timeout is added to the framework

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(this.getSauceUserName());
        loginPage.setPassword(this.getSaucePassword());
        loginPage.clickLoginButton();
    }

    @BeforeMethod
    public void loginBase(){
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass (alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    public String getSauceUserName() {
        return sauceUserName;
    }

    public void setSauceUserName(String sauceUserName) {
        this.sauceUserName = sauceUserName;
    }

    public String getSaucePassword() {
        return saucePassword;
    }

    public void setSaucePassword(String saucePassword) {
        this.saucePassword = saucePassword;
    }
}
