package com.example.sparsh23.laltern;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class ProfileForm extends AppCompatActivity {


    EditText name,company,desg,bustype,addrs,cont,pan,email,webs,state,city,uid;


    public void initvalue()
    {
        name=(EditText)findViewById(R.id.name);
        company=(EditText)findViewById(R.id.company);
        desg=(EditText)findViewById(R.id.desg);
        bustype=(EditText)findViewById(R.)
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



}
