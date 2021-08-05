package pageObjects;

import config.Config;
import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

public class TrainingListPage extends AbstractPage{
    public static final Logger LOG = Logger.getLogger(TrainingListPage.class);
    private By trainingSection = By.xpath("//h1[contains(@class,'section-ui__title') and contains(text(),'TRAINING')]");
    private By searchInput = By.xpath("//input[@placeholder='Search']");
    private By allCitiesCheckbox = By.xpath("//input[@ng-checked='isCountryChecked(activeCountryTab)']/following-sibling::span");
    private By noTrainingsMessage = By.xpath("//span[@ng-show='filteredTrainings.length == 0']");
    private By countryDropdown = By.xpath("//div[@class='location__countries']");


    public TrainingListPage clickSearchInput () {
        getElement(searchInput).click();
        LOG.info("Search Input field is clicked");
        return this;
    }

    public TrainingListPage clickFilterBy (String filter) {
        By filterBySkills = By.xpath(generateFilterByXpath(filter));
        getElement(filterBySkills).click();
        LOG.info(String.format("'%s' filter is selected",filter));
        return this;
    }

    public TrainingListPage clickCheckmark (String skill) {
        By bySkillsCheckmark = By.xpath(generateCheckmarkXpath(skill));
        getElement(bySkillsCheckmark).click();
        LOG.info(String.format("'%s' checkmark was clicked",skill));
        return this;
    }

    public TrainingListPage clickCountry (String country) {
        By countrySelect = By.xpath(generateCountryXpath(country));
        getElement(countrySelect).click();
        LOG.info(String.format("%s is clicked",country));
        return this;
    }

    public TrainingListPage uncheckallCitiesCheckbox () {
        getElement(allCitiesCheckbox).click();
        LOG.info("Location filter is closed");
        return this;
    }

    public List<WebElement> getTrainingList(String parameter) {
        waitPageLoad();
        By trainingList = By.xpath(trainingListItemXpath(parameter));
        List<WebElement> listItems = Driver.getDriver().findElements(trainingList);
        return listItems;
    }

    public String generateFilterByXpath (String filter) {
        String xpath = String.format("//div[@class='drop-down-choose__header']/div[contains(text(),'%s')]",filter);
        return xpath;
    }

    public String generateCheckmarkXpath (String skill) {
        String xpath = String.format("//label[normalize-space()='%s' and contains(@class,'location__not-active-label')]/span[@class='checkmark']",skill);
        return xpath;
    }

    public String generateCountryXpath (String country) {
        String xpath = String.format("//div[@ng-click='activeCountryChoose(locations)' and contains(text(),'%s')]",country);
        return xpath;
    }

    public boolean isNoTrainingsMessageDisplayed() {
        boolean isDisplayed = isDisplayed(noTrainingsMessage);
        LOG.info(String.format("Is noTrainingsMessage displayed': '%s'",isDisplayed));
        return isDisplayed;
    }

    public boolean isCountryDropdownDisplayed() {
        boolean isDisplayed = isDisplayed(countryDropdown);
        LOG.info(String.format("Is countryDropdown displayed': '%s'",isDisplayed));
        return isDisplayed;
    }

    public String trainingListItemXpath (String parameter) {
        Properties prop = Config.readProperties();
        final String parameterTitle = prop.getProperty("parameter.title");
        final String parameterCountry = prop.getProperty("parameter.country");
        final String titlePath = prop.getProperty("training.item.title");
        final String countryPath = prop.getProperty("training.item.country");
        String xpath = new String();
        if (parameter.equals(parameterTitle)) {
            xpath = String.format("//div[contains(@class,'training-list__container')]/div[@training-item='itemTraining']//%s]", titlePath);
        }
        else if (parameter.equals(parameterCountry)) {
            xpath = String.format("//div[contains(@class,'training-list__container')]/div[@training-item='itemTraining']//%s]", countryPath);
        }
        else
            System.out.println("You have configured incorrect training_item_parameter="+ parameter +" Please, check test_file.xml config");
        return xpath;
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
}
