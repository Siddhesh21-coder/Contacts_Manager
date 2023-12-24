package com.codersarena.contactsmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contacts {
    @ColumnInfo(name="contacts_id")
    @PrimaryKey(autoGenerate = true)
    private int ID;
    @ColumnInfo(name="contacts_name")
    private String  name;
    @ColumnInfo(name="contacts_email")
    private String email;
    @ColumnInfo(name="contacts_dob")
    private String dob;

    public Contacts( String name, String email, String dob) {

        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Contacts() {
    }
}
