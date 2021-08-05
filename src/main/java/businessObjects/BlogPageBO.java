package businessObjects;

import config.BlogTabs;
import config.Config;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObjects.BlogPage;
import pageObjects.TrainingListPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class BlogPageBO extends HomePageBO {
    public BlogPageBO verifyBlogTabs (){
                List<WebElement> blogTabsArray = new BlogPage().
                        getBlogPageTabs();
                ArrayList<String> expectedTabs = new ArrayList<>();
                expectedTabs.add(BlogTabs.NEWS.getTitle());
                expectedTabs.add(BlogTabs.REAL_STORIES.getTitle());
                expectedTabs.add(BlogTabs.MATERIALS.getTitle());
                expectedTabs.add(BlogTabs.HARD_SKILLS.getTitle());
                expectedTabs.add(BlogTabs.SOFT_SKILLS.getTitle());
                expectedTabs.add(BlogTabs.EVENTS.getTitle());
                SoftAssert soft = new SoftAssert();
                for (int i = 0; i < blogTabsArray.size(); i++) {
                    String text = blogTabsArray.get(i).getText();
                    soft.assertTrue(text.contentEquals(expectedTabs.get(i)), String.format("Expected tab:%s'. Actual Tab:'%s'", expectedTabs.get(i), text));
                }
                soft.assertAll();
            return this;
    }
}
