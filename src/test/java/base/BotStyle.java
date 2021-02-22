package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BotStyle {

    public static void typeText(WebDriver driver, By by, String text){
        WebElement e = driver.findElement(by);
        e.clear();
        e.sendKeys(text);
    }
}
