package newCases;

import config.Log4jPropertiesConfiguration;
import driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

public abstract class BaseTest {

    private Logger LOG = Logger.getLogger(BaseTest.class);
    private Test test;

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        Driver.initDriver();
        // LOG = Logger.getLogger(method.getDeclaringClass());
        // test = method.getAnnotation(Test.class);
        // LOG.info(String.format("Test '%s' started.",method.getName()));
        // LOG.info(String.format("Description: %s.",test.description()));
    }


    @AfterTest(alwaysRun = true)
    public void afterTest(){
 //       LOG.info(String.format("Test '%s' completed.",method.getName()));
        Driver.quitDriver();
    }
}