package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class BaseTests {

    public WebDriver driver;

    /**
     * This configuration will be included in all of the test cases
     */
    @BeforeClass (alwaysRun = true)
    @Parameters ("browser")
    public void setUp(String browserName){

        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); // Some elements are not interactable unless this timeout is added to the framework
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass (alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
