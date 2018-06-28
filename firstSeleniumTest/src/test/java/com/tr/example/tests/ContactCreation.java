package com.tr.example.tests;

import com.tr.example.model.ContactData;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.File;

public class ContactCreation extends TestBase {
    @Test
    public void createContact() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        File photo = new File("src/test/resources/cat.jpg");
        System.out.println(photo.exists());
        app.getContactHelper().fillContactForm(new ContactData()
                .withfName("Alex1")
                .withlName("Selyavin")
                .withAddress("Israel")
                .withPhoto(photo)
                .withGroup("name 0"));
        app.getContactHelper().confirmContactCreation();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }
}

