package com.tr.example.appManager;


import com.tr.example.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {

        super(driver);
    }

    public void initContactCreation() {
        driver.findElement(By.xpath("//a[@href='edit.php']")).click();
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getfName());

        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contactData.getlName());

        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(contactData.getAddress());

        attach(By.name("photo"), contactData.getPhoto());
        new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }


    public void confirmContactCreation() {

        driver.findElement(By.name("submit")).click();
    }

    public int getContactCount() {

        return driver.findElements(By.name("selected[]")).size();
    }

    public void initContactDeletion() {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void selectContact() {
        driver.findElement(By.name("selected[]")).click();
    }
}

