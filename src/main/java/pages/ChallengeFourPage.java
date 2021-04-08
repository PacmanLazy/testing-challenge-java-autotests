package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CnpNumber;

import java.text.ParseException;

public class ChallengeFourPage {
    public static final int ELEMENT_WAIT_TIMEOUT = 40;
    public static final int VALID_VALUES_REQUIRED_COUNT = 5;

    @FindBy(name="CNP")
    WebElement cnpInput;

    @FindBy(name = "formSubmit")
    WebElement submitBtn;

    @FindBy(className = "values-tested")
    WebElement validValuesCounter;

    @FindBy(xpath="//input[@value='Send name']")
    WebElement sendNameBtn;

    public WebElement getValidValuesCounterElement() {
        return validValuesCounter;
    }

    public void submitFormWithRandomValue() throws ParseException {
        String value = CnpNumber.generateRandomCNP();
        cnpInput.sendKeys(value);
        submitBtn.click();
    }

    public int getValidValuesCounter() {
        return Integer.parseInt(validValuesCounter.getText());
    }

    public boolean sendNameBtnIsDisplayed() {
        return sendNameBtn.isDisplayed();
    }
}
