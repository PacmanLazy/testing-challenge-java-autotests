package pages;

import entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChallengeTenPage {
    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(xpath = "//input[@value='Submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@class='confirm t15']/table/tbody/tr/th")
    List<WebElement> userTableCells;

    public List<WebElement> getUserTableCells() {
        return userTableCells;
    }

    public User registerUser() {
        User user = User.generateRandomUser();

        this.userName.sendKeys(user.getUserName());
        this.password.sendKeys(user.getPassword());
        this.firstName.sendKeys(user.getFirstName());
        this.lastName.sendKeys(user.getLastName());
        submitBtn.click();

        return user;
    }
}
