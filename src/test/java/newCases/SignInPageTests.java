package newCases;

import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInPageTests extends BaseTest {

    @Parameters ({ "page_url","email","expected_result" })
    @Test(description = "Scenario with verifying all the criteria using hard asserts")
    public void verifyEmailCriteriaHardAsserts(String pageUrl,String email, Boolean expected_result) {
        new HomePage()
                .openHomePage(pageUrl)
                .clickSignInButton();
        new SignInPage()
                .enterEmail(email)
                .verifyContinueBtnEnabledHard(expected_result);
    }

    @Parameters ({ "page_url","email","expected_result" })
    @Test(description = "Scenario with verifying all the criteria using soft asserts")
    public void verifyEmailCriteriaSoftAsserts(String pageUrl,String email, Boolean expected_result) {
        new HomePage()
                .openHomePage(pageUrl)
                .clickSignInButton();
        new SignInPage()
                .enterEmail(email)
                .verifyContinueBtnEnabledSoft(expected_result);
    }

    @Parameters ({ "page_url","email","expected_result" })
    @Test(description = "Scenario with verifying only 'boundary values' criteria")
    public void verifyEmailBoundary(String pageUrl,String email, Boolean expected_result) {
        new HomePage()
                .openHomePage(pageUrl)
                .clickSignInButton();
        new SignInPage()
                .enterEmail(email)
                .verifyContinueBtnEnabledSoft(expected_result);
        //.clickContinueBtn()
        //.enterPassword(password)
        //.clickSubmitSignInBtn();
    }
}
