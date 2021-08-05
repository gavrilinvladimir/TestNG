package newCases;

import config.Log4jPropertiesConfiguration;
import driver.Driver;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

public abstract class BaseTest {

    private Logger LOG = Logger.getLogger(BaseTest.class);
    private Test test;

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        Driver.initDriver();
        BasicConfigurator.configure();
    }


    @AfterTest(alwaysRun = true)
    public void afterTest(){
        Driver.quitDriver();
    }
}