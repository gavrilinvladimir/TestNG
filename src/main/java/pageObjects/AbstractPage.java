package pageObjects;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {

    private WebDriverWait wait =  new WebDriverWait(Driver.getDriver(), 10);

    AbstractPage() {
    }

    public void  openPage(final String url) {
        Driver.getDriver().get(url);
    }

     public WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    List<WebElement> getElements(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return Driver.getDriver().findElements(locator);
    }

    public boolean isDisplayed(By locator) {
        try {
            return getElement(locator)
                    .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isEnabled(By locator) {
        try {
            return getElement(locator)
                    .isEnabled();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public void scrollToElement (WebDriver driver, By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getElement(element));
    }

    public void waitPageLoad() {
        new WebDriverWait(Driver.getDriver(), 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
