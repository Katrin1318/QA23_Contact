package com.telran.contacts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        //login tab not present
        if (!isElementPresent(By.cssSelector(".login_login__3EHKB"))) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        //click on login tab
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        //fill registration form
        fillRegistrationLoginForm("korner_15@mail.com", "Sd3567890$");
        //click on login button
        click(By.xpath("//button[contains(.,' Login')]"));
        //Assert: User logged in
        Assert.assertTrue(isElementPresent(By.xpath("a[contains(.,'CONTACTS')]")));
    }
    ////a[contains(.,'CONTACTS')]
}
