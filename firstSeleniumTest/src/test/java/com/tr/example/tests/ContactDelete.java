package com.tr.example.tests;

import org.testng.annotations.Test;

public class ContactDelete extends TestBase{
    @Test
    public void contactDeletion(){
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().confirmAlert();
    }
}

