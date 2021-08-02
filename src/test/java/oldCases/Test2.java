package oldCases;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test2 extends Driver {
    @Test (description="Verify user is not logged in with invalid password")
    public void verifyLoginWithInvalidPassword () throws InterruptedException {
        initDriver();
        getDriver().get("https://training.by/#!/Home?lang=en");

        getDriver().findElement(By.className("header-auth__signin")).click();
        getDriver().findElement(By.id("username")).sendKeys("havrylinvolodymyr@gmail.com");
        getDriver().findElement(By.id("kc-login-next")).click();
        getDriver().findElement(By.id("password")).sendKeys("TestPWD2");
        getDriver().findElement(By.id("kc-login")).click();

        Thread.sleep(2000);
        WebElement errorMessageInvalidPwd = Driver.getDriver().findElement(By.xpath("//span[starts-with(text(),'We can') and contains(text(),'t find user with such credentials.')]"));
        Assert.assertTrue(errorMessageInvalidPwd.isDisplayed(), "There is no error message");

        quitDriver();
    }
}
