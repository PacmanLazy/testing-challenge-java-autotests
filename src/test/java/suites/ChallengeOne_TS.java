package suites;

import base.TestBase;
import data.providers.ChallengeOneDataProvider;
import entities.VerificationData;
import org.testng.annotations.Test;
import pages.ChallengeOnePage;
import utils.Navigator;
import utils.Utils;

import java.util.LinkedList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChallengeOne_TS extends TestBase {
    @Test(dataProvider = "challenge-one-dp", dataProviderClass = ChallengeOneDataProvider.class)
    public void challengeOneTest(LinkedList<VerificationData> verificationDataList) {
        ChallengeOnePage challengeOnePage = Navigator.openChallengeOnePage(webDriver);

        verificationDataList.forEach(verificationData -> {
            challengeOnePage.submitFormWithFirstNameValue(verificationData.getVerificationValue(), webDriver);
            Utils.waitWebElementIsVisible(webDriver, challengeOnePage.getVerificationCounterElement(), ChallengeOnePage.ELEMENT_WAIT_TIMEOUT);

            boolean containsDescription = challengeOnePage.verificationDescriptionsContains(verificationData.getVerificationDescription());

            assertTrue(containsDescription, String.format("Failed verification: %s", verificationData.getVerificationDescription()));
            assertEquals(challengeOnePage.getVerificationCounter(), verificationData.getVerificationCounter());
        });
    }
}
