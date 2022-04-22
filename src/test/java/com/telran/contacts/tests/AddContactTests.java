package com.telran.contacts.tests;

import com.telran.contacts.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(!app.getHeader().isSignOutBtnPresent()) {
            app.getUser().login();
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis()/ 1000) % 3600);
        app.getContact().addContact(new Contact().setName("Korn").setLastname("Eva").setPhone("12345" + i).setEmail("eva" + i + "@gmail.com")
                .setAddress("Kiev").setDesc("butterfly"));

        Assert.assertTrue(app.getContact().isContactCreated("Korn"));

    }

}
