package com.telran.contacts.tests;

import org.testng.annotations.Test;

public class OpenHomePageTests extends TestBase{

    @Test
    public void openHomePageTest() {
        System.out.println("opened home page");
        //check to displayed Home Component form
        //driver.findElements(By.cssSelector("div:nth-child(2) > div > div"));
        app.getHomePage().isHomeComponentPresent();
        //System.out.println("Home Component: " + isElementPresent2(By.cssSelector("div:nth-child(2) > div > div")));
    }

}
