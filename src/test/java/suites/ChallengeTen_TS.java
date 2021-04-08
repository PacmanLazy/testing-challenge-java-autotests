package suites;

import base.TestBase;
import entities.User;
import org.testng.annotations.Test;
import pages.ChallengeLoginPage;
import pages.ChallengeMainPage;
import pages.ChallengeTenPage;
import utils.ChallengeTenUtils;
import utils.Navigator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChallengeTen_TS extends TestBase {
    @Test
    public void registerAndLogin(){
        ChallengeTenPage challengeTenPage = Navigator.openChallengeTenPage(webDriver);

        User user = challengeTenPage.registerUser();
        boolean userCreated = ChallengeTenUtils.userCreated(challengeTenPage.getUserTableCells(), user);

        assertTrue(userCreated);

        ChallengeLoginPage challengeLoginPage = Navigator.openChallengeLoginPage(webDriver);

        ChallengeMainPage challengeMainPage = challengeLoginPage.loginWithCredentials(user, webDriver);

        assertEquals(challengeMainPage.getCurrentUrl(), Navigator.CHALLENGE_LOGIN_MAIN_URL);
        assertTrue(challengeMainPage.containsH1ElementWithText());
    }
}
