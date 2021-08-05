package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SignInPage extends AbstractPage{
    public static final Logger LOG = Logger.getLogger(SignInPage.class);
    private By emailInput = By.id("username");
    private By continueBtn = By.id("kc-login-next");
    private By passwordInput = By.id("password");
    private By submitSignInBtn = By.id("kc-login");
    private By loginFailedErrorMessage = By.xpath("//span[@class='error-text']");


    public SignInPage enterEmail (String email){
        getElement(emailInput).sendKeys(email);
        LOG.info("Email was entered.");
        return this;
    }

    public SignInPage clickContinueBtn (){
        getElement(continueBtn).click();
        LOG.info("Continue button was clicked.");
        return this;
    }

    public SignInPage enterPassword (String password){
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public SignInPage clickSubmitSignInBtn (){
        getElement(submitSignInBtn).click();
        LOG.info("Submit Sign In button was clicked.");
        return this;
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is loginFailedErrorMessage displayed': '%s'",isDisplayed));
        return isDisplayed;
    }

    public boolean isContinueBtnEnabled() {
        boolean isEnabled = getElement(continueBtn).isEnabled();
        LOG.info(String.format("Is Continue button enabled': '%s'",isEnabled));
        return isEnabled;
    }

    public void verifyContinueBtnEnabledHard(Boolean result){
        Assert.assertTrue(isContinueBtnEnabled() == result, String.format("Is Continue button Enabled': '%s'",isContinueBtnEnabled()));
    }
    public void verifyContinueBtnEnabledSoft(Boolean result){
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(isContinueBtnEnabled() == result, String.format("Is Continue button Enabled': '%s'",isContinueBtnEnabled()));
        soft.assertAll();
    }


}
