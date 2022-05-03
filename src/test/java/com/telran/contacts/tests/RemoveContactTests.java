package com.telran.contacts.tests;

import com.telran.contacts.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isSignOutBtnPresent()) {
            app.getUser().login();
        }
        int i = (int) ((System.currentTimeMillis()/ 1000) % 3600);
        app.getContact().addContact(new Contact().setName("Korn").setLastname("Eva").setPhone("12345" + i)
                .setEmail("eva" + i + "@gmail.com")
                .setAddress("Kiev").setDesc("butterfly"));
    }

    @Test
    public void removeContactTest() throws InterruptedException {
        int sizeBefore = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore);
        app.getContact().removeContact();
        Thread.sleep(2000);
        int sizeAfter = app.getContact().sizeOfContacts();
        System.out.println(sizeAfter);
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }

    @Test
    public void removeAllContactTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getContact().addContact(new Contact().setName("Korn").setLastname("Eva").setPhone("12345" + i)
                .setEmail("eva" + i + "@gmail.com")
                .setAddress("Kiev").setDesc("butterfly"));
        app.getContact().removeAllContacts();
        Assert.assertTrue(app.getContact().isContactNotHere());
    }


}
