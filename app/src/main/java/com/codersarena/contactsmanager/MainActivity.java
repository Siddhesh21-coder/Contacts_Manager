package com.codersarena.contactsmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codersarena.contactsmanager.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contacts = new ArrayList<>();

    private MyAdapter myAdapter;
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainActivityClickHandler(this);
        mainBinding.setClickHandler(handlers);

        RecyclerView recyclerView = mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        contactDatabase =ContactDatabase.getInstance(this);
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
//        Contacts c1 = new Contacts("Jack","jack@gmail.com","31/12/1999");
//        viewModel.addNewContact(c1);
        viewModel.getAllContacts().observe(this,
                new Observer<List<Contacts>>() {
                    @Override
                    public void onChanged(List<Contacts> contacts1) {
                        contacts.clear();
                        for(Contacts c: contacts1) {
                            Log.v("TAGY",c.getName());
                            contacts.add(c);

                        }
                        myAdapter.notifyDataSetChanged();
                    }
                });
        myAdapter = new MyAdapter(contacts);
        recyclerView.setAdapter(myAdapter);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Contacts c = contacts.get(viewHolder.getAdapterPosition());
                viewModel.deleteNewContact(c);
            }
        }).attachToRecyclerView(recyclerView);
    }
}