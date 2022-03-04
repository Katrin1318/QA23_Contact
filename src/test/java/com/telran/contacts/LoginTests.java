package com.telran.contacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        //click on login tab
        clickOnLoginTab();
        if (!isRegistrationLoginFormPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginRegisteredUserPositiveTest() {
        //fill login form
        fillRegistrationLoginForm("korner_15@mail.com", "Sd3567890$");
        //click on Login button
        clickOnLoginButton();
        //Assert: User logged in
        Assert.assertTrue(isContactTabPresent());
    }

    @Test(priority = 2)
    public void loginRegisteredUserNegativeTest() {
        //click(By.xpath("//a[contains(.,'LOGIN')]"));
        fillRegistrationLoginForm("korner_15@mail.com", "Sd3567890");
        clickOnLoginButton();
        Assert.assertTrue(isAlertPresent());
        // assert 'Login Failed with code 400' displayed (homework)
    }

}
