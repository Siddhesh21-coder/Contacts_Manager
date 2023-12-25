package com.codersarena.contactsmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.room.Index;

public class AddNewContactClickHandler {
    Contacts contacts;
    Context context;
    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contacts, Context context,MyViewModel myViewModel) {
        this.contacts = contacts;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void onSubmitBtnClicked(View view) {
        if (contacts.getName()==null || contacts.getEmail()==null || contacts.getDob()==null)
        {
            Toast.makeText(context, "Data fields cannot be null", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i =new Intent(context,MainActivity.class);
            i.putExtra("Name",contacts.getName());
            i.putExtra("Email",contacts.getEmail());
            i.putExtra("Dob",contacts.getDob());
            Contacts c = new Contacts(
                    contacts.getName(),
                    contacts.getEmail(),
                    contacts.getDob()
            );
            myViewModel.addNewContact(c);
            context.startActivity(i);
        }
    }
}
