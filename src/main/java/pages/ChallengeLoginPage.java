package pages;

import entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengeLoginPage {
    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[text()='log in']")
    WebElement loginBtn;

    public void loginWithCredentials(User user) {
        userName.sendKeys(user.getUserName());
        password.sendKeys(user.getPassword());
        loginBtn.click();
    }
}
