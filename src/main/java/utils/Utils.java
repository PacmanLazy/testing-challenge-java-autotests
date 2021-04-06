package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    public static void waitWebElementIsVisible(WebDriver webDriver, WebElement webElement, int timeout){
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.visibilityOf(webElement));
    }
}
