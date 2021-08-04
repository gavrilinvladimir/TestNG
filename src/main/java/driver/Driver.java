package driver;

import config.Config;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class Driver {
    private static WebDriver webDriver;
    public static void initDriver() {
        Properties prop = Config.readProperties();
        final String browserName = prop.getProperty("browser.name");
        final String chromeName = prop.getProperty("chrome.name");
        final String chromePath = prop.getProperty("chrome.path");
        final String firefoxName = prop.getProperty("firefox.name");
        final String firefoxPath = prop.getProperty("firefox.path");
        final Integer browserWidth = Integer.parseInt(prop.getProperty("browser.width"));
        final Integer browserHeight = Integer.parseInt(prop.getProperty("browser.height"));
        final Integer driverImplicitWait = Integer.parseInt(prop.getProperty("driver.implicit.wait"));


        if (browserName.equals("chrome")) {
            System.setProperty(chromeName, chromePath);
            webDriver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty(firefoxName, firefoxPath);
            webDriver = new FirefoxDriver();
        } else {
            System.out.println("You have configured incorrect browserName="+ browserName +"Please, check java/config/config.properties file");
        }
        webDriver.manage().window().setSize(new Dimension(browserWidth,browserHeight));
        webDriver.manage().timeouts().implicitlyWait(driverImplicitWait, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver=null;
        }
    }
}
