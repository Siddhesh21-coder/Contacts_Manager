package com.codersarena.contactsmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contacts.class},version = 1)
public abstract class ContactDatabase extends RoomDatabase {
    public abstract ContactDAO getContactDAO();
    private static ContactDatabase dbinstance;
    public static synchronized ContactDatabase getInstance(Context context){
        if (dbinstance == null) {
            dbinstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactDatabase.class,
                    "contacts_db"
            ).fallbackToDestructiveMigration().build();
        }
        return dbinstance;
    }

}
