package com.tr.example.tests;

import com.tr.example.model.GroupData;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModification extends TestBase {
    @Test
    public void testGroupModification() {
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


        @Test
        public void testGroupModificationbyIndex() {
            app.getNavigationHelper().goToGroupPage();
            if (!app.getGroupHelper().isThereAGroup()) {
                app.getGroupHelper().createGroup();
            }
            List<GroupData> before = app.getGroupHelper().getGroupList();
            app.getGroupHelper().selectGroupByIndex(before.size()-1);
            app.getGroupHelper().initGroupModification();
            GroupData group = new GroupData().withId(before.get(before.size()-1).getId())
                    .withName("new Test1").
                            withFooter("July 3").
                            withHeader("July 3");
            app.getGroupHelper().fillGroupForm(group);
            app.getGroupHelper().confirmGroupModification();
            app.getGroupHelper().returnToGroupPage();
            List<GroupData> after = app.getGroupHelper().getGroupList();
            Assert.assertEquals(after.size(), before.size());

            before.remove(before.size()-1);
            before.add(group);

            System.out.println("before"+before);
            System.out.println("after"+ after);

            Assert.assertEquals(new HashSet(before), new HashSet(after));


        }
    }
