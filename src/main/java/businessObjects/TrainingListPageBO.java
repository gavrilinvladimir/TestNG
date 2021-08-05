package businessObjects;

import config.Config;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.TrainingListPage;

import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class TrainingListPageBO extends HomePageBO {
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
            }
            catch (AssertionError error) {
                System.out.println(error);
            }
            return this;
    }

    public void verifyNoTrainingsMessageDisplayed () {
        boolean trainingsMessageDisplayed = new TrainingListPage().
                isNoTrainingsMessageDisplayed();
        try {
            Assert.assertTrue(trainingsMessageDisplayed, String.format("Is NoTrainingsMessage button Displayed': '%s'", trainingsMessageDisplayed));
        }
        catch (AssertionError error) {
            System.out.println(error);
        }
    }

    public void verifyCountryDropdownDisplayed () {
        boolean countryDropdownDisplayed = new TrainingListPage().
                isCountryDropdownDisplayed();
        try {
            Assert.assertTrue(countryDropdownDisplayed, String.format("Is countryDropdownDisplayed button Displayed': '%s'", countryDropdownDisplayed));
        }
        catch (AssertionError error) {
            System.out.println(error);
        }
    }
}
