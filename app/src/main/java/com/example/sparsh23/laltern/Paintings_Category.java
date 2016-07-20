package com.example.sparsh23.laltern;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Paintings_Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paintings__category);
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

        ImageView murals,madhubani,gond,sanjhi,mud;

        murals=(ImageView)findViewById(R.id.murals);
        madhubani=(ImageView)findViewById(R.id.madhubani);
        gond=(ImageView)findViewById(R.id.gond);
        sanjhi=(ImageView)findViewById(R.id.sanji);
        mud=(ImageView)findViewById(R.id.mudpaintings);

        murals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Paintings_Category.this,Stream.class));
            }
        });

        madhubani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Paintings_Category.this,Stream.class));
            }
        });

        gond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Paintings_Category.this,Stream.class));
            }
        });

        sanjhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Paintings_Category.this,Stream.class));
            }
        });

        mud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Paintings_Category.this,Stream.class));
            }
        });


    }


    }


