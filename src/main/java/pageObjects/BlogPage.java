package pageObjects;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class BlogPage extends AbstractPage{
    public static final Logger LOG = Logger.getLogger(BlogPage.class);
    private By blogTab = By.xpath("//div[@class='tab-nav']//a[contains(@class,'tab-nav__item')]/span");

    public List<WebElement> getBlogPageTabs () {
        List<WebElement> blogTabs = Driver.getDriver().findElements(blogTab);
        return blogTabs;
    }


}
