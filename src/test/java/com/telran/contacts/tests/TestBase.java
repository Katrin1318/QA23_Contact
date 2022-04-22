package com.telran.contacts.tests;

import com.telran.contacts.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {


    protected static ApplicationManager app = new ApplicationManager();

    //@BeforeSuite
    @BeforeMethod
    public void setUp() {
        app.init();
    }

    //@AfterSuite(enabled = false)
    @AfterMethod (enabled = false)
    public void tearDown() {
        app.stop();
    }

}
