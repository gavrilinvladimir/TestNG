package newCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commonActions.LoginToSite;
import businessObjects.TrainingListPageBO;
import pageObjects.TrainingListPage;

public class TrainingListPageTests extends BaseTest {

    @Parameters ({ "page_url","email","password","by_skill","filter_by" })
    @Test(description = "Scenario with verifying all the criteria using hard asserts")

    public void verifyUserIsLogged(String pageUrl, String email, String password, String by_skill, String filter_by) {
        LoginToSite.loginToSite(pageUrl,email,password);
        new TrainingListPage()
                .clickTrainingListPageButton()
                .clickSearchInput()
                .uncheckallCitiesCheckbox()
                .clickFilterBySkills(filter_by)
                .clickJavaCheckmark(by_skill)
                .verifyTraniingListItemShown(by_skill);
        //new TrainingListPageBO()
        //        .verifyResultsContainsJava();
    }
}
