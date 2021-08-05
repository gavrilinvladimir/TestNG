package businessObjects;

import org.apache.log4j.Logger;
import org.testng.Assert;
import pageObjects.HomePage;

public class HomePageBO {
    public static final Logger LOG = Logger.getLogger(HomePageBO.class);
    public void verifyUserIsLoggedIn(){
        boolean userNameDisplayed = new HomePage().
                isUserNameDisplayed();
        Assert.assertTrue(userNameDisplayed,"User is not logged in");
        LOG.info("Verified: User is logged");
    }
}
