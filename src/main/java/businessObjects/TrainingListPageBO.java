package businessObjects;

import config.Config;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.TrainingListPage;

import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class TrainingListPageBO extends HomePageBO {
    public static final Logger LOG = Logger.getLogger(TrainingListPageBO.class);
    public TrainingListPageBO verifyTrainingListItemTitle (String filterParameter, String validateParameter){
            try {
                Properties prop = Config.readProperties();
                final String multiLocation = prop.getProperty("traning.item.multiLocation");
                List<WebElement> traningListItemShownArray = new TrainingListPage().
                        getTrainingList(filterParameter);
                SoftAssert soft = new SoftAssert();
                Pattern pattern;
                if (filterParameter.contains("Country"))
                    pattern = Pattern.compile(String.format("(%s)|(%s)|(%s)|(%s)", validateParameter, validateParameter.toUpperCase(), validateParameter.toLowerCase(),multiLocation));
                else
                    pattern = Pattern.compile(String.format("(%s)|(%s)|(%s)", validateParameter, validateParameter.toUpperCase(), validateParameter.toLowerCase()));

                for (int i = 0; i < traningListItemShownArray.size(); i++) {
                    String text = traningListItemShownArray.get(i).getText();
                    soft.assertTrue(pattern.matcher(text).find(), String.format("Item doesn't contain word %s': '%s'", validateParameter, text));
                }
                soft.assertAll();
                LOG.info("Verified: All training list items contains Java");
            }
            catch (AssertionError error) {
                LOG.info(error);
            }
            return this;
    }

    public void verifyNoTrainingsMessageDisplayed () {
        boolean trainingsMessageDisplayed = new TrainingListPage().
                isNoTrainingsMessageDisplayed();
        try {
            Assert.assertTrue(trainingsMessageDisplayed, String.format("Is NoTrainingsMessage button Displayed': '%s'", trainingsMessageDisplayed));
            LOG.info("Verified: No training message is displayed");
        }
        catch (AssertionError error) {
            LOG.info(error);
        }
    }

    public void verifyCountryDropdownDisplayed () {
        boolean countryDropdownDisplayed = new TrainingListPage().
                isCountryDropdownDisplayed();
            Assert.assertTrue(countryDropdownDisplayed, String.format("Is country Dropdown Displayed button Displayed': '%s'", countryDropdownDisplayed));
            LOG.info("Verified: Country DropDown is displayed");
    }
}
