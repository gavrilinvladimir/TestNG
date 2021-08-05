package pageObjects;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.regex.Pattern;

public class TrainingListPage extends AbstractPage{
    public static final Logger LOG = Logger.getLogger(TrainingListPage.class);
    private By trainingListPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'training')]");
    private By trainingSection = By.xpath("//h1[contains(@class,'section-ui__title') and contains(text(),'TRAINING')]");
    private By searchInput = By.xpath("//input[@placeholder='Search']");
    private By allCitiesCheckbox = By.xpath("//input[@ng-checked='isCountryChecked(activeCountryTab)']/following-sibling::span");
    private By traningListItemShown = By.xpath("//div[contains(@class,'training-list__container')]/div[@training-item='itemTraining']//div[contains(@class,'training-item__title')]");

    public TrainingListPage clickTrainingListPageButton () {
        getElement(trainingListPageButton).click();
        LOG.info("Training List button was clicked.");
        return this;
    }
/*
    public TrainingListPage scrollToTrainingListSection () {
        new WebDriverWait(Driver.getDriver(), 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        scrollToElement(Driver.getDriver(), trainingSection);
        return this;
    }

    public TrainingListPage scrollToallCitiesCheckbox () {
        new WebDriverWait(Driver.getDriver(), 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        scrollToElement(Driver.getDriver(), allCitiesCheckbox);
        return this;
    }
 */

    public TrainingListPage clickSearchInput () {
        getElement(searchInput).click();
        LOG.info("Search Input field was clicked.");
        return this;
    }

    public TrainingListPage clickFilterBySkills (String filter_by) {
        By filterBySkills = By.xpath(generateFilterByXpath(filter_by));
        getElement(filterBySkills).click();
        LOG.info("By skills filter was clicked.");
        return this;
    }

    public TrainingListPage clickJavaCheckmark (String by_skill) {
        By bySkillsCheckmark = By.xpath(generateBySkillCheckmarkXpath(by_skill));
        getElement(bySkillsCheckmark).click();
        LOG.info("Java checkmark was clicked.");
        return this;
    }

    public TrainingListPage uncheckallCitiesCheckbox () {
        getElement(allCitiesCheckbox).click();
        LOG.info("Location filter is closed.");
        return this;
    }

    public TrainingListPage verifyTraniingListItemShown(String by_skill) {
        waitPageLoad();
        List<WebElement> traningListItemShownArray = Driver.getDriver().findElements(traningListItemShown);
        SoftAssert soft= new SoftAssert();
        Pattern pattern = Pattern.compile(String.format("(%s)|(%s)|(%s)",by_skill,by_skill.toUpperCase(),by_skill.toLowerCase()));
        for (int i=0;i<traningListItemShownArray.size(); i++) {
            String title = traningListItemShownArray.get(i).getText();
            soft.assertTrue(pattern.matcher(title).find(),String.format("Title doesn't contain word %s': '%s'",by_skill,title));
        }
        soft.assertAll();
        return this;
    }

    public String generateFilterByXpath (String filter_by) {
        String xpath = String.format("//div[@class='drop-down-choose__header']/div[contains(text(),'%s')]",filter_by);
        return xpath;
    }

    public String generateBySkillCheckmarkXpath (String by_skill) {
        String xpath = String.format("//label[normalize-space()='Java' and contains(@class,'location__not-active-label')]/span[@class='checkmark']",by_skill);
        return xpath;
    }
}
