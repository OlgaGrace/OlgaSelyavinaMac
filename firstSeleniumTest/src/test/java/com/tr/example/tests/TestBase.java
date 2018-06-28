package com.tr.example.tests;

import com.tr.example.appManager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        app.start();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }
    Logger logger = LoggerFactory.getLogger(GroupCreation.class);
    @BeforeMethod
    public void logTestStart(Method m){
        logger.info("Start "+m.getName());
    }
    @AfterMethod (alwaysRun = true)
    public void logTestStop(Method m){
        logger.info("Stop "+m.getName());
    }
}
