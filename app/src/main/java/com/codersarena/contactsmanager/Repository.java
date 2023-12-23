package com.codersarena.contactsmanager;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    //ROOM Database
    private final ContactDAO contactDAO;
    Handler handler;
    ExecutorService executor;
    public Repository(Application application) {
        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);
        this.contactDAO = contactDatabase.getContactDAO();

        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }
    public void addContact(Contacts contacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contacts);
            }
        });

    }
    public void deleteContact(Contacts contacts){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contacts);

            }
        });
    }
    public LiveData<List<Contacts>> getAllContacts(){

        return contactDAO.getAllContacts();
    }
}
