package oldCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {
    @Test (description="Verify user is successfully logged in with appropriate credentials")
    public void verifyLoginWithAppropriateCredentials (){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#!/Home?lang=en");

        WebElement signIn = driver.findElement(By.className("header-auth__signin"));
        signIn.click();

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("havrylinvolodymyr@gmail.com");

        WebElement nextBtn = driver.findElement(By.id("kc-login-next"));
        nextBtn.click();

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("TestPWD1");

        WebElement signInPwd = driver.findElement(By.id("kc-login"));
        signInPwd.click();

        WebElement username = driver.findElement(By.className("user-info__name"));
        Assert.assertEquals(username.getText(),"volodymyr havrylin","User is not logged in");

        driver.quit();
    }
}
