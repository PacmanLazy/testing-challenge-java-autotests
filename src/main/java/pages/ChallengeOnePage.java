package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChallengeOnePage {
    public static final int ELEMENT_WAIT_TIMEOUT = 40;

    @FindBy(id = "firstname")
    WebElement firstNameInput;

    @FindBy(className = "values-tested")
    WebElement verificationCounter;

    @FindBy(name= "formSubmit")
    WebElement submitBtn;

    @FindAll(@FindBy(xpath = "//ul[@class='values-description t10']/li"))
    List<WebElement> verificationDescriptions;

    public WebElement getVerificationCounterElement() {
        return verificationCounter;
    }

    public void submitFormWithFirstNameValue(String firstName) {
        firstNameInput.sendKeys(firstName);
        submitBtn.click();
    }

    public int getVerificationCounter() {
        return Integer.parseInt(verificationCounter.getText());
    }

    public boolean verificationDescriptionsContains(String value) {
        return verificationDescriptions.stream()
                .anyMatch(element -> value.equalsIgnoreCase(element.getText()));
    }

}
