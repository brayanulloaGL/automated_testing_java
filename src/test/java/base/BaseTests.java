package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.InventoryPage;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.io.FileUtils.copyFile;

public class BaseTests {

    public WebDriver driver;
    private InventoryPage inventoryPage;

    private String sauceUserName;
    private String saucePassword;
    private String url;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser", "url", "implicitWait"})
    public void setUp(String browserName, String URL, int implicitWait) throws Exception {

        this.setSauceUserName(System.getenv("SAUCE_USERNAME"));
        this.setSaucePassword(System.getenv("SAUCE_PASSWORD"));
        this.setUrl(URL);

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Browser is not correct");
        }

        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void goHome() {
        this.setInventoryPage(
                new LoginPage(driver)
                        .setUsername(this.getSauceUserName())
                        .setPassword(this.getSaucePassword())
                        .clickLoginButton());
    }

    @AfterMethod(alwaysRun = true, dependsOnMethods = "screenShot")
    public void logout() {
        this.getInventoryPage().clickMenuButton();
        this.getInventoryPage().clickLogoutButton();
    }

    @AfterMethod()
    public void screenShot(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()){
            try{
                TakesScreenshot screenshot = (TakesScreenshot)driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                copyFile(src, new File("resources/screenshots/" + result.getName()+ ".png"));
                System.out.println("Successfully captured a screenshot");
            }catch (Exception e){
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
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

    public InventoryPage getInventoryPage() {
        return inventoryPage;
    }

    public void setInventoryPage(InventoryPage inventoryPage) {
        this.inventoryPage = inventoryPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
