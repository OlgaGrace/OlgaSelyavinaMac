package com.tr.example.appManager;


import com.tr.example.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation(By locator) {

        click(locator);
    }

    public void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
    }

    public void initNewGroupCreation() {
        click(By.name("new"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));

    }

    public void deleteGroup() {
        click(By.name("delete"));

    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void confirmGroupModification() {
        click(By.name("update"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup() {
        initNewGroupCreation();
        fillGroupForm(new GroupData()
                .withName("name")
                .withHeader("header")
                .withFooter("footer"));
        submitGroupCreation(By.name("submit"));
        returnToGroupPage();
    }
}
