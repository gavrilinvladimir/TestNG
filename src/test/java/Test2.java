import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test2 {
    @Test (description="Verify user is not logged in with invalid password")
    public void verifyLoginWithInvalidPassword () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://training.by/#!/Home?lang=en");

        driver.findElement(By.className("header-auth__signin")).click();
        driver.findElement(By.id("username")).sendKeys("havrylinvolodymyr@gmail.com");
        driver.findElement(By.id("kc-login-next")).click();
        driver.findElement(By.id("password")).sendKeys("TestPWD2");
        driver.findElement(By.id("kc-login")).click();

        Thread.sleep(2000);
        WebElement errorMessageInvalidPwd = driver.findElement(By.xpath("//span[starts-with(text(),'We can') and contains(text(),'t find user with such credentials.')]"));
        Assert.assertTrue(errorMessageInvalidPwd.isDisplayed(), "There is no error message");

        driver.quit();
    }
}
