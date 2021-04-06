package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ChallengeOnePage;

public class Navigator {
    private static final String CHALLENGE_ONE_URL = "http://testingchallenges.thetestingmap.org/index.php";

    public static ChallengeOnePage openChallengeOnePage(WebDriver webDriver) {
        webDriver.navigate().to(CHALLENGE_ONE_URL);
        return PageFactory.initElements(webDriver, ChallengeOnePage.class);
    }
}
