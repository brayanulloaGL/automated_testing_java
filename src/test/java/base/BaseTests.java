package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class BaseTests {

    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); // Some elements are not interactable unless this timeout is added to the framework
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
