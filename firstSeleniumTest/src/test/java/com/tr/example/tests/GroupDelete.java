package com.tr.example.tests;

import com.tr.example.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDelete extends TestBase {
    @Test
    public void groupDeletionTest() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup();
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
    }
    @Test
    public void groupDeletionByIndexTest() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup();
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
      //  int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroupByIndex(before.size()-1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
      //  int after = app.getGroupHelper().getGroupCount();
        List <GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size()-1);
        before.remove(before.size()-1);
    }

}
