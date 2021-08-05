package newCases;

import businessObjects.BlogPageBO;
import businessObjects.TrainingListPageBO;
import commonActions.LoginToSite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.BlogPage;
import pageObjects.HomePage;
import pageObjects.TrainingListPage;

public class BlogPageTests extends BaseTest {

    @Parameters ({ "page_url","email","password"})
    @Test(description = "Scenario for check training for Java and message for Ruby")

    public void verifyTrainingListSkillJava(String pageUrl, String email, String password) {
        LoginToSite.loginToSite(pageUrl,email,password);
        new HomePage()
                .clickBlogPageButton();
        new BlogPageBO()
                .verifyBlogTabs();
    }
}
