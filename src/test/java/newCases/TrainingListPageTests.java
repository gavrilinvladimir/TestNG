package newCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commonActions.LoginToSite;
import businessObjects.TrainingListPageBO;
import pageObjects.HomePage;
import pageObjects.TrainingListPage;

public class TrainingListPageTests extends BaseTest {

    @Parameters ({ "page_url","email","password","by_skill","filter_by","training_item_parameter","by_skill_2" })
    @Test(description = "Scenario for check training for Java and message for Ruby")
    public void verifyTrainingListSkill(String pageUrl, String email, String password, String by_skill, String filter_by, String training_item_parameter, String by_skill_2) {
        LoginToSite.loginToSite(pageUrl,email,password);
        new HomePage()
                .clickTrainingListPageButton();
        new TrainingListPage()
                .clickSearchInput()
                .uncheckallCitiesCheckbox()
                .clickFilterBy(filter_by)
                .clickCheckmark(by_skill);
        new TrainingListPageBO()
                .verifyTrainingListItemTitle(training_item_parameter,by_skill);
        new TrainingListPage()
                .clickCheckmark(by_skill)
                .clickCheckmark(by_skill_2);
        new TrainingListPageBO()
                .verifyNoTrainingsMessageDisplayed();
    }
    @Parameters ({ "page_url","email","password","country","city","training_item_parameter" })
    @Test(description = "Scenario for check no training message for Ruby")
    public void verifyTrainingListLocationUkraine(String pageUrl, String email, String password, String country, String city, String training_item_parameter) {
        LoginToSite.loginToSite(pageUrl,email,password);
        new HomePage()
                .clickTrainingListPageButton();
        new TrainingListPage()
                .clickSearchInput();
        new TrainingListPageBO()
                .verifyCountryDropdownDisplayed();
        new TrainingListPage()
                .uncheckallCitiesCheckbox()
                .clickCountry(country)
                .clickCheckmark(city);
        new TrainingListPageBO()
                .verifyTrainingListItemTitle(training_item_parameter,country);
    }
}
