package data.providers;

import entities.VerificationData;
import org.testng.annotations.DataProvider;

import java.util.LinkedList;

public class ChallengeOneDataProvider {
    private static final String AVERAGE_VALUE = "aaa";
    private static final String MIN_VALUE = "a";
    private static final String MAX_VALUE = new String(new char[30]).replace('\0', 'a');
    private static final String MORE_THAN_MAX_VALUE = new String(new char[31]).replace('\0', 'a');
    private static final String BASIC_SQL_INJECTION_VALUE = "'some';";
    private static final String HTML_TAGS_VALUE = "<h1>abc</h1>";
    private static final String NON_ALPHABETIC_CHARS_VALUE = "aa5a&@dkfdk";
    private static final String SPACE_IN_THE_MIDDLE_VALUE = "tWsi slf";

    private static final String AVERAGE_VALUE_EXPECTED_DESCRIPTION = "Average value";
    private static final String MIN_VALUE_EXPECTED_DESCRIPTION = "Minimum value";
    private static final String MAX_VALUE_EXPECTED_DESCRIPTION = "Maximum values";
    private static final String MORE_THAN_MAX_VALUE_EXPECTED_DESCRIPTION = "More than maximum values";
    private static final String BASIC_SQL_INJECTION_VALUE_EXPECTED_DESCRIPTION = "Basic Sql injection";
    private static final String HTML_TAGS_VALUE_EXPECTED_DESCRIPTION = "You used html tags";
    private static final String NON_ALPHABETIC_CHARS_VALUE_EXPECTED_DESCRIPTION = "Average value";
    private static final String SPACE_IN_THE_MIDDLE_VALUE_EXPECTED_DESCRIPTION = "Space in the middle";

    private static LinkedList<VerificationData> verificationDataList() {
        LinkedList<VerificationData> dataList = new LinkedList<>();
        dataList.add(new VerificationData(AVERAGE_VALUE, AVERAGE_VALUE_EXPECTED_DESCRIPTION, 1));
        dataList.add(new VerificationData(MIN_VALUE, MIN_VALUE_EXPECTED_DESCRIPTION, 2));
        dataList.add(new VerificationData(MAX_VALUE, MAX_VALUE_EXPECTED_DESCRIPTION, 3));
        dataList.add(new VerificationData(MORE_THAN_MAX_VALUE, MORE_THAN_MAX_VALUE_EXPECTED_DESCRIPTION, 4));
        dataList.add(new VerificationData(NON_ALPHABETIC_CHARS_VALUE, NON_ALPHABETIC_CHARS_VALUE_EXPECTED_DESCRIPTION, 5));
        dataList.add(new VerificationData(HTML_TAGS_VALUE, HTML_TAGS_VALUE_EXPECTED_DESCRIPTION, 6));
        dataList.add(new VerificationData(BASIC_SQL_INJECTION_VALUE, BASIC_SQL_INJECTION_VALUE_EXPECTED_DESCRIPTION, 7));
        dataList.add(new VerificationData(SPACE_IN_THE_MIDDLE_VALUE, SPACE_IN_THE_MIDDLE_VALUE_EXPECTED_DESCRIPTION, 8));
        return dataList;
    }

    @DataProvider(name = "challenge-one-dp")
    public static Object[][] getDataProvider() {
        return new Object[][] {
                {verificationDataList()}
        };
    }
}
