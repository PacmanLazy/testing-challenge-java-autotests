package suites;

import base.TestBase;
import org.testng.annotations.Test;
import pages.ChallengeFourPage;
import utils.Navigator;
import utils.Utils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.ParseException;

public class ChallengeFour_TS extends TestBase {
    @Test
    public void cnpNumberTest() throws ParseException {
        ChallengeFourPage challengeFourPage = Navigator.openChallengeFourPage(webDriver);

        for (int i = 1; i <= ChallengeFourPage.VALID_VALUES_REQUIRED_COUNT; i++) {
            challengeFourPage.submitFormWithRandomValue();

            if(i != ChallengeFourPage.VALID_VALUES_REQUIRED_COUNT) {
                Utils.waitWebElementIsVisible(webDriver, challengeFourPage.getValidValuesCounterElement(), ChallengeFourPage.ELEMENT_WAIT_TIMEOUT);
                assertEquals(challengeFourPage.getValidValuesCounter(), i);
            }
        }

        assertTrue(challengeFourPage.sendNameBtnIsDisplayed());
    }
}
