package utils;

import config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ChallengeLoginPage;
import pages.ChallengeOnePage;
import pages.ChallengeTenPage;

public class Navigator {
    private static final String TESTING_CHALLENGE_URL = Configuration.getConfigurationValue("url");
    private static final String CHALLENGE_ONE_URL = TESTING_CHALLENGE_URL.concat("/index.php");
    private static final String CHALLENGE_TEN_URL = TESTING_CHALLENGE_URL.concat("/challenge10.php");
    private static final String CHALLENGE_LOGIN_URL = TESTING_CHALLENGE_URL.concat("/login/login.php");
    private static final String CHALLENGE_LOGIN_MAIN_URL = TESTING_CHALLENGE_URL.concat("/login/main.php");

    public static ChallengeOnePage openChallengeOnePage(WebDriver webDriver) {
        webDriver.navigate().to(CHALLENGE_ONE_URL);
        return PageFactory.initElements(webDriver, ChallengeOnePage.class);
    }

    public static ChallengeTenPage openChallengeTenPage(WebDriver webDriver) {
        webDriver.navigate().to(CHALLENGE_TEN_URL);
        return PageFactory.initElements(webDriver, ChallengeTenPage.class);
    }

    public static ChallengeLoginPage openChallengeLoginPage(WebDriver webDriver) {
        webDriver.navigate().to(CHALLENGE_LOGIN_URL);
        return PageFactory.initElements(webDriver, ChallengeLoginPage.class);
    }
}
