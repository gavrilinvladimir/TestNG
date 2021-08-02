package newCases;

import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInPageTests extends BaseTest {

    @Parameters ({ "page_url","email","password" })
    @Test(description = "Scenario with verifying all the criteria using hard asserts")
    public void verifyEmailCriteriaHardAsserts(String pageUrl,String email,String password) {
        new HomePage()
                .openPage(pageUrl);
                //.clickSignInButton();
        new SignInPage()
                .enterEmail(email)
                .verifyContinueBtnEnabledHard();
                //.clickContinueBtn()
                //.enterPassword(password)
                //.clickSubmitSignInBtn();
    }

}
