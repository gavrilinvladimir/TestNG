package newCases;

import config.Log4jPropertiesConfiguration;
import driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public abstract class BaseTest extends Driver {

    private Logger LOG = Logger.getLogger(BaseTest.class);
    private Test test;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initDriver();
        // LOG = Logger.getLogger(method.getDeclaringClass());
        // test = method.getAnnotation(Test.class);
        // LOG.info(String.format("Test '%s' started.",method.getName()));
        // LOG.info(String.format("Description: %s.",test.description()));
    }


    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
 //       LOG.info(String.format("Test '%s' completed.",method.getName()));
        quitDriver();
    }
}