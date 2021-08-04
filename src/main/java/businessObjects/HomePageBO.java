package businessObjects;

import org.testng.Assert;
import pageObjects.HomePage;

public class HomePageBO {
    public void verifyUserIsLoggedIn(){
        boolean userNameDisplayed = new HomePage().
                isUserNameDisplayed();
        Assert.assertTrue(userNameDisplayed,"User is not logged in");
    }
}
