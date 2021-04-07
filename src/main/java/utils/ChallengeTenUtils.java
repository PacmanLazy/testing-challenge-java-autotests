package utils;

import entities.User;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChallengeTenUtils {
    public static boolean userCreated(List<WebElement> userTableCells, User user) {
        int cellPerRowCount = 8;
        int userNameCellIndex = 1;
        int passwordCellIndex = 2;
        if(userTableCells.size() == 0) {
            return false;
        }

        // cut user table headers part
        List<WebElement> usersSubList = userTableCells.subList(cellPerRowCount, userTableCells.size());
        int chunkCount = usersSubList.size() / cellPerRowCount;

        // iterating table content for defining username and password match
        for (int i = 1; i <= chunkCount; i++) {
            List<WebElement> oneUserDataList = usersSubList.subList(cellPerRowCount*i-cellPerRowCount, cellPerRowCount*i);
            boolean containsUserName = oneUserDataList.get(userNameCellIndex).getText().equals(user.getUserName());
            boolean containsPassword = oneUserDataList.get(passwordCellIndex).getText().equals(user.getPassword());

            if(containsUserName && containsPassword) {
               return true;
            }
        }

        return false;
    }
}
