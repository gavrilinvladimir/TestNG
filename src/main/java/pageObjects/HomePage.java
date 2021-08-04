package pageObjects;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage{
    private static final Logger LOG = Logger.getLogger(HomePage.class);
    private By signInButton = By.className("header-auth__signin");
    private static By topRightCornerUserNameElement = By.className("user-info__name");

    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign in' button clicked");
        return new SignInPage();
    }
    public HomePage openHomePage(final String url) {
        openPage(url);
        LOG.info(String.format("Proceeded to '%s' URL.",url));
        return this;
    }

    public boolean isUserNameDisplayed(){
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        LOG.info(String.format("User is logged in: '%s'",isDisplayed));
        return isDisplayed;
    }
}
