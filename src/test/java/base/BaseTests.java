package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class BaseTests {

    // OPTIONAL: this variable can be protected, that way it can be accessible only by child classes and not public for the entired project
    public WebDriver driver;

    /**
     * This configuration will be included in all of the test cases
     */
    @BeforeClass (alwaysRun = true)
    public void setUp(){
        // 1.
        // Here you need need to take the browser as a parameter from the xml and create and if/switch statement
        // to open the right browser based on value of the parameter define in the TestNG xml
        //
        // 2.
        // It is recommended to not save the driver file in the repo because it is something that constantly change
        // The recommendation is to set the drivers up in the execution machine or in the local machine in these case,
        // based on this line "System.setProperty("webdriver.chrome.driver", "resources/chromedriver");" can be removed
        //
        // 3.
        // For crossbrowsing let's use Chrome, Firefox and headless
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();

        // get the url from the testng.xml files
        driver.get("https://www.saucedemo.com/");
        // Also the timeout can be set in the xml file, to have all these options parameterizable and customizable
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); // Some elements are not interactable unless this timeout is added to the framework
    }

    @BeforeMethod
    public void goHome(){
        // read the url from the testng.xml files, we are using the same url in several parts,
        // so another reason why to have this into the testng.xml file
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass (alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
