package entities;

import utils.Utils;

public class User {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    public User(String userName, String password, String firstName, String lastName){
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public static User generateRandomUser() {
        return new User(
                Utils.generateRandomAlphaNumericString(3, 16),
                Utils.generateRandomPassword(),
                Utils.generateRandomAlphabeticString(3, 30),
                Utils.generateRandomAlphabeticString(3, 30)
        );
    }
}
