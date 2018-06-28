package com.tr.example.model;

import java.io.File;

public class ContactData {
    private String fName;
    private String lName;
    private String address;
    private File photo;
    private String group;

    public String getGroup() {
        return group;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public ContactData withfName(String fName) {
        this.fName = fName;
        return this;
    }

    public ContactData withlName(String lName) {
        this.lName = lName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getAddress() {
        return address;
    }
}

