package com.tr.example.tests;

import com.tr.example.model.GroupData;
import org.testng.annotations.Test;

public class GroupModification extends TestBase {
    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup();
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName("new name")
                .withHeader("new header")
                .withFooter("new footer"));
        app.getGroupHelper().confirmGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }

}
