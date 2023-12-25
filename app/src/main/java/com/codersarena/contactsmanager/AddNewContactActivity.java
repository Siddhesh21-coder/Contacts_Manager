package com.codersarena.contactsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.codersarena.contactsmanager.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {
    private ActivityAddNewContactBinding addNewContactBinding;
    private AddNewContactClickHandler clickHandler;
    private Contacts contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        contacts = new Contacts();
        addNewContactBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_add_new_contact
                );
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        clickHandler = new AddNewContactClickHandler(contacts,
                this,myViewModel);
        addNewContactBinding.setContact(contacts);
        addNewContactBinding.setClickHandler(clickHandler);
    }
}