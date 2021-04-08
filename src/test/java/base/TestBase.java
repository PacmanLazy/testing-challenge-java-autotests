package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;

public class TestBase {
    protected WebDriver webDriver;

    @BeforeMethod
    public void initDriver(){
        webDriver = BrowserFactory.createInstance();
    }

    @AfterMethod
    public void quitDriver() {
        webDriver.quit();
    }
}
