package com.telran.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.util.List;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(!isSignOutBtnPresent()) {
            login();
        }
    }

    @Test
    public void addContactPositiveTest() {
        addContact();

        Assert.assertTrue(isContactCreated("Korn"));

    }

}
