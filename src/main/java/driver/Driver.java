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
        if (prop.getProperty("browser.name").equals("chrome")) {
            System.setProperty(prop.getProperty("chrome.name"), prop.getProperty("chrome.path"));
            webDriver = new ChromeDriver();
        } else if (prop.getProperty("browser.name").equals("firefox")) {
            System.setProperty(prop.getProperty("firefox.name"), prop.getProperty("firefox.path"));
            webDriver = new FirefoxDriver();
        } else {
            System.out.println("You have configured incorrect browserName="+ prop.getProperty("browser.name") +"Please, check java/config/config.properties file");
        }
        webDriver.manage().window().setSize(new Dimension(Integer.parseInt(prop.getProperty("browser.width")),Integer.parseInt(prop.getProperty("browser.height"))));
        webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("driver.implicit.wait")), TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    protected void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver=null;
        }
    }
}
