package com.telran.contacts.tests;

import com.telran.contacts.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        //login tab not present
        if (!app.getHeader().isLoginTabPresent()) {
            //click on log out button
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void registrationPositiveTest() {
        //test: click on login tab
        app.getUser().clickOnLoginTab();
        app.getUser().isRegistrationFormPresent();
        //fill registration form
        app.getUser().fillRegistrationLoginForm(new User().setEmail("korner_15@mail.com").setPassword("Sd3567890$"));
        //click registration button
        app.getUser().clickOnRegistrationButton();
        //check log out button displayed
        app.getHeader().isSignOutButtonPresent();
    }

    @Test
    public void registrationNegativeWithoutPasswordTest() {
        //test: click on login tab
        app.getUser().clickOnLoginTab();
        app.getUser().isRegistrationFormPresent();
        //fill registration form
        app.getUser().fillRegistrationLoginForm(new User().setEmail("korner_15@mail.com"));
        //click registration button
        app.getUser().clickOnRegistrationButton();
        //check log out button displayed
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
