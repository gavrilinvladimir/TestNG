package pageObjects;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TrainingListPage extends AbstractPage{
    public static final Logger LOG = Logger.getLogger(TrainingListPage.class);
    private By trainingListPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'training')]");
    private By trainingSection = By.xpath("//h1[contains(@class,'section-ui__title') and contains(text(),'TRAINING')]");
    private By searchInput = By.xpath("//input[@placeholder='Search']");
    private By filterBySkills = By.xpath("//div[@class='drop-down-choose__header']/div[contains(text(),'By skills')]");
    private By javaCheckmark = By.xpath("//label[normalize-space()='Java' and contains(@class,'location__not-active-label')]/span[@class='checkmark']");
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

    public TrainingListPage clickFilterBySkills () {
        getElement(filterBySkills).click();
        LOG.info("By skills filter was clicked.");
        return this;
    }

    public TrainingListPage clickJavaCheckmark () {
        getElement(javaCheckmark).click();
        LOG.info("Java checkmark was clicked.");
        return this;
    }

    public TrainingListPage uncheckallCitiesCheckbox () {
        getElement(allCitiesCheckbox).click();
        LOG.info("Location filter is closed.");
        return this;
    }

    public TrainingListPage getTraningListItemShown(String by_skill) {
        new WebDriverWait(Driver.getDriver(), 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        List<WebElement> traningListItemShownArray = Driver.getDriver().findElements(traningListItemShown);
//        ArrayList<String> title = new ArrayList();
        SoftAssert soft= new SoftAssert();
        for (int i=0;i<traningListItemShownArray.size(); i++) {
            String title = traningListItemShownArray.get(i).getText();
            soft.assertTrue(title.contains(by_skill),String.format("Title doesn't contain word %s': '%s'",by_skill,title));
            soft.assertAll();
        }
        return this;
    }
}
