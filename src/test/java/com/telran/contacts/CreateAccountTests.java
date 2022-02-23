package com.telran.contacts;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        //login tab not present
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            //click on log out button
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test
    public void registrationPositiveTest() {
        //test: click on login tab
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        isRegistrationFormPresent();
        //fill registration form
        fillRegistrationLoginForm("korner_15@mail.com", "Sd3567890$");
        //click registration button
        click(By.xpath("//button[contains(.,' Registration')]"));
        //check log out button displayed
        isSignOutButtonPresent();
    }

}
