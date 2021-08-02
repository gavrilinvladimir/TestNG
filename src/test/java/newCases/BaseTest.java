package newCases;

import driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public abstract class BaseTest extends Driver {

    private Logger LOG = Logger.getLogger(BaseTest.class);
    private Test test;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        initDriver();
        // LOG = Logger.getLogger(method.getDeclaringClass());
        // test = method.getAnnotation(Test.class);
        // LOG.info(String.format("Test '%s' started.",method.getName()));
        // LOG.info(String.format("Description: %s.",test.description()));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(final Method method){
        LOG.info(String.format("Test '%s' completed.",method.getName()));
        quitDriver();
    }
}