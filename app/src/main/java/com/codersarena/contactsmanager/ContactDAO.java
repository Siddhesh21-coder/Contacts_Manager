package com.codersarena.contactsmanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {
    @Insert
    void insert(Contacts contact);
    @Delete
    void delete(Contacts contact);
    @Update
    void update(Contacts contact);
    @Query("SELECT * FROM contacts")
    List<Contacts> getAllContacts();
}
