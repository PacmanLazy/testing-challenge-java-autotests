package pages;

import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChallengeMainPage {
    private static final String CHALLENGE_MAIN_PAGE_H1_TXT = Configuration.getConfigurationValue("main_page_h1_txt");
    private static final String H1_ELEMENT_LOCATOR = String.format("//h1[text()='%s']", CHALLENGE_MAIN_PAGE_H1_TXT);
    private WebDriver webDriver;

    public ChallengeMainPage(WebDriver driver) {
        webDriver = driver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public boolean containsH1ElementWithText() {
        try {
            webDriver.findElement(By.xpath(H1_ELEMENT_LOCATOR));
        } catch (NoSuchElementException e) {
            return false;
        }

        return true;
    }
}
