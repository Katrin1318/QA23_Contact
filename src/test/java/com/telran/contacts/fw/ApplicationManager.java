package com.telran.contacts.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager  {

    public WebDriver driver;

    UserHelper user;
    ContactHelper contact;
    HeaderHelper header;
    HomePageHelper homePage;

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public UserHelper getUser() {
        return user;
    }


    public void init() {
        driver = new ChromeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        header = new HeaderHelper(driver);
        homePage = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

}
