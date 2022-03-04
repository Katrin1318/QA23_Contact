package com.telran.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        //login tab not present
        if (!isLoginTabPresent()) {
            //click on log out button
            clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void registrationPositiveTest() {
        //test: click on login tab
        clickOnLoginTab();
        isRegistrationFormPresent();
        //fill registration form
        fillRegistrationLoginForm("korner_15@mail.com", "Sd3567890$");
        //click registration button
        clickOnRegistrationButton();
        //check log out button displayed
        isSignOutButtonPresent();
    }

}
