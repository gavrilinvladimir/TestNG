package commonActions;

import businessObjects.HomePageBO;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class LoginToSite {

    public static void loginToSite(String pageUrl, String email, String password) {
        new HomePage()
                .openHomePage(pageUrl)
                .clickSignInButton();
        new SignInPage()
                .enterEmail(email)
                .clickContinueBtn()
                .enterPassword(password)
                .clickSubmitSignInBtn();
        new HomePageBO()
                .verifyUserIsLoggedIn();
    }
}
