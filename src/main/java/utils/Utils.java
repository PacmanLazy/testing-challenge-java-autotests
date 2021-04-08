package utils;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static void waitWebElementIsVisible(WebDriver webDriver, WebElement webElement, int timeout){
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitWebElementValueIsEmpty(WebDriver webDriver, WebElement webElement, int timeout){
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.textToBePresentInElementValue(webElement, ""));
    }

    public static String generateRandomAlphaNumericString(int minLength, int maxLength){
        RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder()
        .withinRange('0', 'z').filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS).build();

        return stringGenerator.generate(minLength, maxLength);
    }

    public static String generateRandomAlphabeticString(int minLength, int maxLength){
        RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z').filteredBy(CharacterPredicates.LETTERS).build();

        return stringGenerator.generate(minLength, maxLength);
    }

    public static String generateRandomNumericString(int length){
        RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder()
                .withinRange('0', '9').build();

        return stringGenerator.generate(length);
    }

    public static String generateRandomAlphabeticString(int length){
        RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z').filteredBy(CharacterPredicates.LETTERS).build();

        return stringGenerator.generate(length);
    }

    public static String generateRandomSpecialCharacters(int length) {
        RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder()
                .withinRange(33, 45).build();

        return stringGenerator.generate(length);
    }

    public static String generateRandomPassword() {
        String passwordStringBase = generateRandomAlphabeticString(6)
                .concat(generateRandomSpecialCharacters(2))
                .concat(generateRandomNumericString(2));

        List<Character> pwChars = passwordStringBase.chars()
                .mapToObj(data -> (char) data)
                .collect(Collectors.toList());
        Collections.shuffle(pwChars);

        return pwChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
